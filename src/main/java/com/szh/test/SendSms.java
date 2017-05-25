/*
package com.szh.test; */
/**
　　依赖如下
 <dependency>
  <groupId>com.dajie</groupId>
  <artifactId>dj-sms-api</artifactId>
  <version>1.0.8</version>
</dependency> 
　　　　<groupId>com.dajie</groupId>
　　　　<artifactId>dj-sms-client</artifactId>
　　　　<version>1.0.6</version>
 *//*


import com.dajie.sms.SmsServicesContext;
import com.dajie.sms.service.SmsService;
import java.util.HashMap;
import java.util.Map;
import com.dajie.sms.model.DefaultTplKey;
import com.dajie.sms.model.SmsResponse;

public class SendSms {
  private static SmsService smsService = SmsServicesContext.getInstance().getSmsService();
  public static void main(String[] args) {

       Map<String, String> map = new HashMap<String, String>();

           map.put("jobname", "job名称");

           map.put(DefaultTplKey.UID.getKey(), "34105731");        //用户UID
           map.put(DefaultTplKey.MOBILE.getKey(), "18201090152");  //用户手机号
    　　　   String result = smsService.sendSMS(10105, map).getResult();  //短信模板号,调用接口，返回数据库主键．

    }
}
*/
