package com.szh.test;

import com.dajie.common.util.Base64;
import com.dajie.mail.MailManagerServicesContext;
import com.dajie.mail.service.MailManagerService;
import com.dajie.mail.constant.MailTplKeys;
import com.dajie.mail.constant.MailTplKeys;

import java.util.HashMap;
import java.util.Map;

/**
 * * Created by yunbinan on 15-9-29.
 */
public class MailManagerTest {
    private static final MailManagerService mailManagerService = MailManagerServicesContext.getInstance().getMailService();

    private void sendMail() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hrname", "您好，感谢注册");
        // map.put("subject"  ,"宋志豪" );
        map.put("JOBNAME", "宋志豪");
        map.put("button", "宋志豪");
        map.put("content", "你好测试，感谢注册<img src=\"https://f1.dajieimg.com/n/micro_blog/T1uabvBg_v1R4cSCrK_c.png\">");

        map.put("button_link", "https://f1.dajieimg.com/n/micro_blog/T1uabvBg_v1R4cSCrK_c.png");
        for (int i = 0; i < 50; i++) {

            map.put("username." + i, "宋志豪" + i);
            map.put("corpname." + i, "大街网" + i);
            map.put("jobinfo." + i, "java开发" + i);
            map.put("schoolname." + i, "java开发" + i);

            map.put("education." + i, "北京大学" + i);
            map.put("location." + i, "本科" + i);
            if (i == 0)
                map.put("resumeurl." + i, "https://job.dajie.com/recruit/apply/resume/browse?from=name&pageType=search&encryptedIds=d327956d58a4e36771bc587cd618ef61");
            else
                map.put("resumeurl." + i, "https://job.dajie.com/recruit/index");
        }
        map.put(MailTplKeys.KEY_TO_UID, "10327062");
        // map.put("KEY_DATA_TYPE", "310700");
        map.put(MailTplKeys.KEY_TO_EMAIL, "1551151530@qq.com");                         //收件人Email
        //  map.put(MailTplKeys.KEY_TO_EMAIL, "hetaonapoleon@126.com");                         //收件人Email
        //   map.put(MailTplKeys.KEY_TO_EMAIL, "405588818@qq.com");                         //收件人Email


        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10542");                                      //邮件模板id
        boolean results = mailManagerService.sendMail(map, 10542);
        System.out.println(results);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("jobName", "java开发");

        map.put(MailTplKeys.KEY_TO_UNAME, "宋先生");
        map.put(MailTplKeys.KEY_TO_UID, "10327062");
        map.put(MailTplKeys.KEY_TO_EMAIL, "1551151530@qq.com");                         //收件人Email
        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10711");                                      //邮件模板id
        boolean results = mailManagerService.sendNoRealTimeMail(map);
        System.out.println(results);
    }

}
