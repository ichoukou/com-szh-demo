package main.java.com.szh.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhihaosong on 16-6-27.
 */
public class SmsPattern {
    public static void main(String[] args) {
        Pattern smsClickPatten = Pattern.
                compile("channelcode(=|%3D)(.*?)(&|%26)uid(=|%3D)(\\d*)(&|%26)st(=|%3D)(\\d*)(&|%26)tplId(=|%3D)(\\d*)(&|%26)serialId(=|%3D)([\\w-]*)");
        Matcher smsClickkk = smsClickPatten.
                matcher("channelcode=MWPT_DAJIE&uid=34348703&st=201603241031&tplId=10016&serialId=djgk032401");

        if (smsClickkk.find()) {
            String channelCode = smsClickkk.group(2);
            String uid = smsClickkk.group(5);
            String st = smsClickkk.group(8);
            String tplId = smsClickkk.group(11);
            String serialId = smsClickkk.group(14);
            System.out.println(smsClickkk.find() + "\t" + channelCode + "\t" + uid
                    + "\t" + st + "\t" + tplId + "\t" + serialId.trim() + " 1233");
        }

        String res = "http://d-j.me/xSNMWG5";
        res = res.substring(res.indexOf("d-j.me"));
        System.out.println(String.valueOf(res));
    }
}
