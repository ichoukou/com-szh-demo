package com.szh.util;

import com.dajie.mail.MailManagerServicesContext;
import com.dajie.mail.constant.MailTplKeys;
import com.dajie.mail.service.MailManagerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhihaosong on 16-8-17.
 */
public class MailmanagerTest {
    private static final MailManagerService mailManagerService = MailManagerServicesContext.getInstance().getMailService();

    public static void main(String[] args) {
        /*
1，mobile_findpasswordcapcha      10261    userName   code   UID    TO_EMAIL
2，guanke_findpasswordcapcha     10263    userName   code   UID    TO_EMAIL　
3，register                                    10264　 type   url   UID   userName    TO_EMAIL
4，password_find                          10265    url   UID   userName    TO_EMAIL
5，password_mail                         10266    resetPasswordUrl   UID   userName   loginEmail   loginPassword    TO_EMAIL
6，mobile_verifycapcha                 10262    userName   code   UID    TO_EMAIL
         */

//url   UID   userName


        Map<String, String> map = new HashMap<String, String>();

        map.put("remindCount", "5");
        map.put("applyURL","http://job.dajie.com/recruit/apply/index");
        map.put("UID","24363846");
        map.put("unreadCount","5");
        map.put("resumeHandle","0");
        map.put("userName","李志勇");
        map.put("autoLoginURL","http://www.dajie.com/account/login?auth_str\u003df7fd0RZaZOCx0zPQIif7r9rY1X2jMwr2qpVL9Spe8S7hiB3Zng\u0026url\u003dhttp%3A%2F%2Fjob.dajie.com%2Frecruit%2Fapply%2Findex");

        map.put("applyCount","5");

        map.put(MailTplKeys.KEY_TO_EMAIL, "1049799275@qq.com");                         //收件人Email
        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10247");                                      //邮件模板id
        boolean result = mailManagerService.sendEmail(map);
        boolean result1= mailManagerService.isOffLimit("zhihao.song@dajie-inc.com",10269);
        System.out.println(result);
        System.out.println(result1);
    }
}
