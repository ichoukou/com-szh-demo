package hbresponse;

import com.dajie.common.util.StringUtil;
import com.dajie.mail.constant.MailTplKeys;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.math.NumberUtils;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhihaosong on 16-11-28.
 */
public class test {
    private static byte[] decodeBytes(String s) {
        if (s == null)
            return new byte[0];
        try {
            return Hex.decodeHex(s.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }

    private static String decodeMessage(int dc, byte[] buf) {
        if (buf == null)
            return "";
        try {
            // 这里只解码了8
            if (dc == 8)
                return new String(buf, "UTF-16BE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(buf);
    }

    public static String decodeMessage(String dc, String str) {
        if (StringUtil.isEmpty(str))
            return "";
        byte[] buf = null;
        try {
            buf = Hex.decodeHex(str.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
        if (buf == null)
            return "";
        try {
            // 这里只解码了8
            if (NumberUtils.toInt(dc) == 8)
                return new String(buf, "UTF-16BE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(buf);
    }

    private void test1(final String tplId) {
        sendMail(tplId);
    }

    private void test2(final String tplId) {
        sendMail(tplId);
    }

    private void sendMail(final String tplId) {

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "\t" + tplId + "\t" + i);
                    try {
                        TimeUnit.SECONDS.sleep(Integer.parseInt(tplId));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                new String("ssss");
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
        a = 0;
        for (int i = 0; i < 10000; i++) {
            new String("ssss");
        }
        long end2 = System.currentTimeMillis();
        Double aaaa = 111.01;
        System.out.println(2.00 - 1.10);
        System.out.println(end2 - end);

        final long MICROS = 24 * 60 * 60 * 1000 * 1000;
        final long MICROS2 = 24l * 60 * 60 * 1000 * 1000;

        final long MILLIS = 24 * 60 * 60 * 1000;
        System.out.println(MICROS);
        System.out.println(MICROS2);

        System.out.println((long) MICROS / MILLIS);
        test test1 = new test();
        //test1.test1("1");
        //test1.test2("4");

        String ss = "sfds";
        Integer.parseInt(ss);
    }


}
