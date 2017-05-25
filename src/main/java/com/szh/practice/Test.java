package com.szh.practice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhihaosong on 17-3-23.
 */
public class Test {
    public static void main(String[] args) {
        List<Map<String, String>> datas = new ArrayList();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("UID", "100706839");
        map1.put("content", "小松，天津市尚儒乐文教育咨询有限公司邀请您前往参加面试： d-j.me/8pJNkSm");
        map1.put("MOBILE", "18201090152");
        map1.put("invitationId", "34105552");
        map1.put("corpName", "sdsfs");
        map1.put("talkDate", "查看。");
        map1.put("TPL_ID", "10102");
        datas.add(map1);

        Map<String, String> map12 = new HashMap<String, String>();
        map12.put("UID", "100706839");
        map12.put("content", "你好，天津市尚儒乐文教育咨询有限公司邀请您前往参加面试： d-j.me/8pJNkSm");
        map12.put("MOBILE", "18611261236");
        map12.put("invitationId", "34105552");
        map12.put("corpName", "sdsfs");
        map12.put("talkDate", "查看。");
        map12.put("TPL_ID", "10102");
        datas.add(map1);
        //  String result = smsService.sendSMSBatch(datas);



        String aa = "a" + "b" + "c";
        System.out.println(aa);


    }
}
