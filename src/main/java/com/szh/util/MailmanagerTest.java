package main.java.com.szh.util;

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
        Map<String, String> map = new HashMap<String, String>();
        map.put("HRNAME", "李方芳");
        map.put("UID", "7833678");
        map.put("UNAME", "薄晓燕");
        map.put("invitationIdCode", "32bed4d0f6285ded3519c9e42b276436");
        map.put("invitationId", "725680751");

        map.put("TO_EMAIL", "1551151530@qq.com");                                   //收件人Email
        map.put("s_TPL_VERSION_ID", "9911");                                      //邮件模板id
        boolean result = mailManagerService.sendEmail(map);
        System.out.println(result);
    }
}
