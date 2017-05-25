package com.szh.test;

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

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
   /*     for (int i = 0; i < 3; i++) {
            map.put("candidate." + i, "宋志豪" + i);
            map.put("corpname." + i, "大街网" + i);
            map.put("jobinfo." + i, "java开发" + i);
            map.put("schoolname." + i, "北京大学" + i);
            map.put("education." + i, "本科" + i);
            map.put("location." + i, "山东" + i);
            if (i == 0)
                map.put("resumeurl." + i, "https://job.dajie.com/recruit/apply/resume/browse?from=name&pageType=search&encryptedIds=d327956d58a4e36771bc587cd618ef61");
            else
                map.put("resumeurl." + i, "https://job.dajie.com/recruit/index");
        }*/
        map.put("jobname", "java开发");
        map.put(MailTplKeys.KEY_TO_UNAME, "宋先生");
        map.put(MailTplKeys.KEY_TO_UID, "34105731");
        map.put(MailTplKeys.KEY_TO_EMAIL, "1551151530@qq.com");                         //收件人Email
        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10451");                                      //邮件模板id
        boolean results = mailManagerService.sendNoRealTimeMail(map);

        System.out.println(results);
    }

}
