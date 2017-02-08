package com.szh.httpClient;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.*;

/**
 * Created by zhihaosong on 16-10-22.
 */
public class HttpTest {


    public static void main(String[] args) {
        String url = "http://112.124.24.5/api/MsgSend.asmx/GetBalance";

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("userCode", "用户名"));
        nvps.add(new BasicNameValuePair("userPass", "密码"));
        String post = httpPost(url, nvps);  //post请求

        String getparam = "userCode=用户名&userPass=密码";
        String result = httpGet(url, getparam); //get请求
    }

    public static String httpPost(String url, List<NameValuePair> params) {
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instreams = entity.getContent();
                result = convertStreamToString(instreams);
                System.out.println(result);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static String httpGet(String url, String params) {
        String result = "";
        try {
            HttpClient client = new DefaultHttpClient();
            if (params != "") {
                url = url + "?" + params;
            }
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instreams = entity.getContent();
                result = convertStreamToString(instreams);
                System.out.println(result);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
