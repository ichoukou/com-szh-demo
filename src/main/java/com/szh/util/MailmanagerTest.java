package com.szh.util;

import com.dajie.mail.MailManagerServicesContext;
import com.dajie.mail.constant.MailTplKeys;
import com.dajie.mail.service.MailManagerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhihaosong on 16-8-17.
 */
public class MailmanagerTest {
    private static final MailManagerService mailManagerService = MailManagerServicesContext.getInstance().getMailService();

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("exchcode", "5sss");
        map.put("number", "2212");
        map.put("hrname", "宋先生");
        map.put("jobname", "开发工程师");
        map.put("UNAME", "冯斯琪");
        map.put("autoLoginURL", "http://www.dajie.com/account/login?auth_str\u003df7fd0RZaZOCx0zPQIif7r9rY1X2jMwr2qpVL9Spe8S7hiB3Zng\u0026url\u003dhttp%3A%2F%2Fjob.dajie.com%2Frecruit%2Fapply%2Findex");
        map.put("applyCount", "5");


        map.put("UID", "34936991");

        map.put(MailTplKeys.KEY_TO_EMAIL, "siqi.feng@dajie-inc.com");                         //收件人Email
        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10405");                                      //邮件模板id
        System.out.println(mailManagerService.sendNoRealTimeMail(map));

    }
}
