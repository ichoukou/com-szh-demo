package com.szh.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.formula.functions.Match;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhihaosong on 16-3-10.
 */
public class test {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private static Pattern httpPattern = Pattern.compile("\\s*((A|a)?(URL|url))\\s*\\{\\s*(((http|ftp|https)://)*(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*([a-zA-Z0-9\\&#%_\\./-~-]*)?)\\s*\\}\\s*");
    //   private static Logger logger = LoggerFactory.getLogger(main.java.com.szh.test.test.class);

    public static String updateShortUrl(String content, Map<String, String> para) {
        try {
            Matcher matcher1 = httpPattern.matcher(content.trim());
//            System.out.println(matcher1.group(2) + "\t" + matcher1.group(0) + "\t" + matcher1.group(1));

            if (matcher1.find() && !matcher1.group(0).contains("d-j.me")) {//
                String t_content = content;
                System.out.println(matcher1.group(0) + "\t" + matcher1.group(1) + "\t" + matcher1.group(2) + "\t\t" + matcher1.group(3) + "\t\t" + matcher1.group(4));
                System.out.println(matcher1.group(5) + "\t" + matcher1.group(6) + "\t" + matcher1.group(7) + "\t" + matcher1.group(8) + "\t" + matcher1.group(9));
                // content = matcher1.replaceAll(" " + RenderTemplate.getInstance().generateShortUrl(para, matcher1.group(2).trim()).trim() + " ");
            } else {
                System.out.printf(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static String toHexString(String str) {
        byte[] buf = null;
        try {
            buf = str.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            int v = buf[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv.toUpperCase());
        }
        return stringBuilder.toString();
    }

    private static String hexString = "0123456789ABCDEF";

    public static String encode(String str) throws UnsupportedEncodingException {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes("GB2312");
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f)));
        }
        return sb.toString();
    }

    public String sendSmsByHBGet(String mobile, String smscontent) {
        String result = "";
        int billingCount = 0;
        String content = toHexString("【大街职位小推手】" + smscontent);
        //   logger.info("sendSmsByHBGet content ------> content:{} content:{}", "【大街职位小推手】" + smscontent, content);
        try {
            HttpClient client = new DefaultHttpClient();
            // 设置连接超时时间(单位毫秒)
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
            // 设置读数据超时时间(单位毫秒)
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 3000);
            HttpGet httpRequst = new HttpGet(MessageFormat.format("{0}/mt?un={1}&pw={2}&da={3}&sm={4}&dc=15&rd=1", "http://101.227.68.49:7891", "10690060", "DaJie2016", mobile, content));
            HttpResponse response = client.execute(httpRequst);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);//取出应答字符串
            result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
            if (result.contains("id")) {
                result = result.split("=")[1];
                System.out.println("sendSmsByHBGet success -> " + result);
                // logger.info("sendSmsByHBGet success ------> smsRequest:{} return result:{}", smsRequest.getId(), result);
            } else {
                System.out.println("sendSmsByHBGet success -> " + result);

                //logger.info("sendSmsByHBGet fail ------> smsRequest:{} return result:{}", smsRequest.getId(), result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //    logger.error("sendSmsByHBGet error:" + e.getMessage(), e);
        }
        return result;
    }

    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<Object>());
        Map<String, String> para = new HashMap<String, String>();
        String content = "亲爱的宋先生，你住址附近正在招优质管理岗位很适合你，薪资高于你的预期。点击： URL{https://www.dajie.com} 查看【坏男孩】";
        updateShortUrl(content, para);
        String str = "【大街职位小推手】大街网测试. d-j.me/HI4XjdF 退订回T";
        byte[] bytes = " ".getBytes();
        content = toHexString(str);

        try {
            content = encode(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(content);


        try {
            System.out.println(URLEncoder.encode("【大街网】大街网注册验证码473013，10分钟内有效。", "GBK"));

            System.out.println(URLDecoder.decode("%B4%F3%BD%D6%CD%F8%D7%A2%B2%E1%D1%E9%D6%A4%C2%EB473013%A3%AC10%B7%D6%D6%D3%C4%DA%D3%D0%D0%A7%A1%A3%A1%BE%B4%F3%BD%D6%CD%F8%A1%BF","GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
