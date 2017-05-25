package com.szh.httpClient;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class HttpJsonExample {
    private static final Logger LOG = Logger.getLogger(HttpJsonExample.class);
    private static String account = "dh33092";
    private static String password = "46UZAmed";
    private static String phone = "18201090152";

    public static String sign = "";
    public static String subcode = "";
    public static String msgid = UUID.randomUUID().toString().replace("-", "");
    public static String sendtime = "";

    public HttpJsonExample() {
    }

    public static void main(String[] args) {
        try {
            String e = "您好！你有一个快递,请注意查收。";

            JSONHttpClient jsonHttpClient = new JSONHttpClient("https://www.dh3t.com");
            jsonHttpClient.setRetryCount(1);
            String sendhRes = jsonHttpClient.sendSms(account, password, phone, e, sign, subcode);
            System.out.println("提交单条普通短信响应：" + sendhRes);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}