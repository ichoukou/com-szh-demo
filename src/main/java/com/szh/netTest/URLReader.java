package com.szh.netTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {
@Deprecated
    public static void main(String[] args) throws Exception {
        //创建URL对象
        URL url = new URL("https://www.dajie.com/");
        //由URL对象获取URLConnection对象
        URLConnection conn = url.openConnection();
        //由URLConnection获取输入流，并构造DataInputStream对象
        DataInputStream dis = new DataInputStream(conn.getInputStream());
        //由URLConnection获取输出流，并构造PrintStream对象
        PrintStream ps = new PrintStream(conn.getOutputStream());
        String line = dis.readLine();
        System.out.println(line);
        ps.println("client…"); //向服务器写出字符串 "client…"

    }
}