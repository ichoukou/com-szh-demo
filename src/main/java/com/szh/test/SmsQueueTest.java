package com.szh.test;

import com.dajie.sms.queue.model.SmsInfoBean;
import com.dajie.sms.queue.model.SmsUnsubscribeBean;
import com.dajie.sms.queue.smsInfo.SmsInfoMQContext;
import com.dajie.sms.queue.smsInfo.SmsInfoMQPutter;
import com.dajie.sms.queue.smsInfo.SmsInfoMQTaker;
import com.dajie.sms.queue.unsubscribe.SmsUnsubscribeMQContext;
import com.dajie.sms.queue.unsubscribe.SmsUnsubscribeMQPutter;
import com.dajie.sms.queue.unsubscribe.SmsUnsubscribeMQTaker;

/**
 * Created by zhihaosong on 17-6-27.
 */
public class SmsQueueTest {

    private static SmsInfoMQPutter smsInfoMQPutter = SmsInfoMQContext.getInstance().getSmsInfoMQPutter();
    private static SmsInfoMQTaker smsInfoMQTaker = SmsInfoMQContext.getInstance().getSmsInfoMQTaker();

    public void insertSmsUnsubscribeMQ(int uid) {
        SmsInfoBean smsInfoBean = new SmsInfoBean();
        smsInfoBean.setUid(uid);
        smsInfoBean.setMobile("18201090152");

        try {
            smsInfoMQPutter.addSmsInfoBeanMQ(smsInfoBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            new SmsQueueTest().insertSmsUnsubscribeMQ(i * i * i);
            System.out.println("insertSmsUnsubscribeMQ :" + i * i * i);
        }

        try {
            for (int i = 0; true; i++) {
                System.out.println("get  smsUnsubscribeB :");

                SmsInfoBean smsInfoBean = smsInfoMQTaker.getSmsInfoBean();
                System.out.println("  get  smsUnsubscribeB :" + smsInfoBean.getUid() + smsInfoBean.getMobile());
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
