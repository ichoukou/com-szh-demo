package util;

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
        Map<String, String> data = new HashMap<String, String>();
        data.put(MailTplKeys.KEY_TO_EMAIL, "1551151530@qq.com");                                //收件人Email
        data.put(MailTplKeys.KEY_TPL_VERSION_ID, "9750");
        boolean result = mailManagerService.sendEmail(data);
        System.out.println(result);
    }
}
