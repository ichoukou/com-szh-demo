package com.szh.httpClient;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

public class JSONHttpClient {
    private static final Logger LOG = Logger.getLogger(HttpClient.class);
    private static final AtomicBoolean isSwitch = new AtomicBoolean(false);
    private static final String SEND_URL = "/json/sms/Submit";
    private static final String GET_REPORT_URL = "/json/sms/Report";
    private static final String DELIVER_URL = "/json/sms/Deliver";
    private static final String BATCH_SEND_URL = "/json/sms/BatchSubmit";
    private static final String DEFAULT_RESPONSE = "{\"response\":{result:\"21\",desc:\"数据包/短信内容为空\"}}";
    private int conTimeOut;
    private int readTimeOut;
    private int retryCount;
    private String masterUrl;
    private String slaveUrl;
    boolean isHttps;

    public JSONHttpClient(String masterURL) throws URIException {
        this(masterURL, (String) null);
    }

    public JSONHttpClient(String masterURL, String slaveURL) throws URIException {
        this.conTimeOut = 30000;
        this.readTimeOut = 30000;
        this.retryCount = 3;
        this.masterUrl = "";
        this.slaveUrl = "";
        this.isHttps = false;
        this.masterUrl = this.getSchemaHost(masterURL);
        if (this.masterUrl != null && !"".equals(this.masterUrl.trim())) {
            this.slaveUrl = this.getSchemaHost(slaveURL);
        } else {
            throw new URIException("master URL 地址必须输入");
        }
    }

    private String getSchemaHost(String host) {
        if (host != null) {
            if (host.indexOf("http://") != -1) {
                return host;
            } else if (host.indexOf("https://") != -1) {
                this.isHttps = true;
                return host;
            } else {
                return "http://" + host;
            }
        } else {
            return null;
        }
    }

    public String sendSms(String account, String password, String phones, String content, String sign, String subcode, String msgid, String sendtime) {
        JSONObject param = new JSONObject();
        param.put("account", account);
        param.put("password", DigestUtils.md5Hex(password));
        param.put("msgid", msgid);
        param.put("phones", phones);
        param.put("content", content);
        param.put("sign", sign);
        param.put("subcode", subcode);
        param.put("sendtime", sendtime);
        String requestData = param.toString();
        String resp = this.doPost("/json/sms/Submit", requestData, false);
        return resp;
    }

    public String sendBatchSms(String account, String password, List<SmsData> list) {
        String resp = "{\"response\":{result:\"21\",desc:\"数据包/短信内容为空\"}}";
        if (list != null && !list.isEmpty()) {
            JSONObject param = new JSONObject();
            param.put("account", account);
            param.put("password", DigestUtils.md5Hex(password));
            JSONArray array = new JSONArray();
            Iterator var8 = list.iterator();

            while (var8.hasNext()) {
                SmsData requestData = (SmsData) var8.next();
                JSONObject paramData = new JSONObject();
                paramData.put("msgid", requestData.getMsgid());
                paramData.put("phones", requestData.getPhones());
                paramData.put("content", requestData.getContent());
                paramData.put("sign", requestData.getSign());
                paramData.put("subcode", requestData.getSubcode());
                paramData.put("sendtime", requestData.getSendtime());
                array.add(paramData);
            }

            param.put("data", array);
            String requestData1 = param.toString();
            resp = this.doPost("/json/sms/BatchSubmit", requestData1, false);
        }

        return resp;
    }

    public String sendSms(String account, String password, String phones, String content, String sign, String subcode, String msgid) {
        return this.sendSms(account, password, phones, content, sign, subcode, msgid, "");
    }

    public String sendSms(String account, String password, String phones, String content, String sign, String subcode) {
        return this.sendSms(account, password, phones, content, sign, subcode, "", "");
    }

    public String getReport(String account, String password, String msgid, String phone) {
        JSONObject param = new JSONObject();
        param.put("account", account);
        param.put("password", DigestUtils.md5Hex(password));
        param.put("msgid", msgid);
        param.put("phone", phone);
        String requestData = param.toString();
        String resp = this.doPost("/json/sms/Report", requestData, false);
        return resp;
    }

    public String getReport(String account, String password) {
        return this.getReport(account, password, "", "");
    }

    public String getSms(String account, String password) {
        JSONObject param = new JSONObject();
        param.put("account", account);
        param.put("password", DigestUtils.md5Hex(password));
        String requestData = param.toString();
        String resp = this.doPost("/json/sms/Deliver", requestData, false);
        return resp;
    }

    public String doPost(String url, String data, boolean isReconn) {
        String response = null;
        String requestURL = null;

        try {
            if (isSwitch.get()) {
                if (this.slaveUrl != null && !"".equals(this.slaveUrl.trim())) {
                    requestURL = this.slaveUrl + url;
                    response = this.request(requestURL, data);
                    System.out.println(response);
                }
            } else {
                requestURL = this.masterUrl + url;
                response = this.request(requestURL, data);
            }
        } catch (ConnectTimeoutException var7) {
            this.redirectURL(url, data, isReconn, requestURL, var7);
        } catch (ConnectException var8) {
            this.redirectURL(url, data, isReconn, requestURL, var8);
        } catch (Exception var9) {
            LOG.error("访问：" + requestURL + " 异常:", var9);
            System.err.println(var9);
        }

        return response;
    }

    private String redirectURL(String url, String data, boolean isReconn, String lastRequestURL, Exception e) {
        if (!isSwitch.get()) {
            if (!isReconn && this.slaveUrl != null && !"".equals(this.slaveUrl.trim())) {
                isSwitch.set(true);
                LOG.info("访问：" + lastRequestURL + " 异常,地址已经已被自动切换到从地址");
                return this.doPost(url, data, true);
            }

            LOG.error("访问：" + lastRequestURL + " 异常:", e);
        } else {
            if (!isReconn) {
                isSwitch.set(false);
                LOG.info("访问：" + lastRequestURL + " 异常,地址已经已被自动切换到主地址");
                return this.doPost(url, data, true);
            }

            LOG.error("访问：" + lastRequestURL + " 异常:", e);
        }

        return null;
    }

    private String request(String url, String data) throws HttpException, IOException {
        String response = null;
        PostMethod postMethod = null;
        LOG.info("访问：" + url + " 请求数据:" + data);

        try {
            if (this.isHttps) {
                MySecureProtocolSocketFactory client = new MySecureProtocolSocketFactory();
                Protocol.registerProtocol("https", new Protocol("https", client, 443));
            }

            HttpClient client1 = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Connection", "close");
            postMethod.getParams().setParameter("http.protocol.content-charset", "utf-8");
            byte[] byteData = data.getBytes("utf-8");
            ByteArrayRequestEntity requestEntity = new ByteArrayRequestEntity(byteData);
            postMethod.setRequestEntity(requestEntity);
            HttpConnectionManagerParams managerParams = client1.getHttpConnectionManager().getParams();
            postMethod.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler(this.retryCount, false));
            managerParams.setConnectionTimeout(this.conTimeOut);
            managerParams.setSoTimeout(this.readTimeOut);
            client1.executeMethod(postMethod);
            if (postMethod.getStatusCode() == 200) {
                response = postMethod.getResponseBodyAsString();
                LOG.info("访问：" + url + " 响应数据:" + response);
            } else {
                LOG.error("访问：" + url + "异常，响应状态码：" + postMethod.getStatusCode() + ",响应内容：" + postMethod.getResponseBodyAsString());
            }
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }

        }

        return response;
    }

    public int getConTimeOut() {
        return this.conTimeOut;
    }

    public void setConTimeOut(int conTimeOut) {
        this.conTimeOut = conTimeOut;
    }

    public int getReadTimeOut() {
        return this.readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getRetryCount() {
        return this.retryCount;
    }
}
