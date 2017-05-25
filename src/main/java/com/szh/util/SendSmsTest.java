package com.szh.util;

import com.dajie.sms.SmsServicesContext;
import com.dajie.sms.service.SmsService;

import java.util.HashMap;
import java.util.Map;

import com.dajie.sms.model.SmsRequest;

import java.util.ArrayList;
import java.util.List;

import com.dajie.sms.model.DefaultTplKey;
import com.dajie.sms.model.SmsResponse;

/**
 * Created by yunbinan on 27/11/14.
 */
public class SendSmsTest {
    private static SmsService smsService = SmsServicesContext.getInstance().getSmsService();

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("smscontents", "");
        map3.put("TalentPoolAndRewardRecruit_TYPE", "INVITATION_JOB");
        map3.put("TalentPoolAndRewardRecruit_BIZ", "RewardRecruit");
        map3.put("content", "亲，年薪10-30万名企邀你入职，点击绿色通道申请： d-j.me/La6iJnA 【博为峰】");

        map3.put(DefaultTplKey.CHANNEL_CODE.getKey(), "DHST_DAJIE");        //用户UID
        map3.put(DefaultTplKey.UID.getKey(), "34105731");        //用户UID
        map3.put(DefaultTplKey.MOBILE.getKey(), "18500213714");  //用户手机号
        String result = smsService.sendSMS(10016, map3).getResult();  //短信模板号10084,调用接口，返回数据库主键．
        // System.out.println(result);
        // smsService.qdRemoveBlackMB("18201090152");
        System.out.println(result);
    }
}
