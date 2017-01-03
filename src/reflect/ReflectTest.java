/*
package reflect;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

*/
/**
 * Created by zhihaosong on 16-8-22.
 *//*

public class ReflectTest {

    public static boolean loadstatus(String cmd) {
        return SmsLoader.getIsLoad().get();
    }

    public static boolean stopload(String cmd) {
        return true;
    }

    public static boolean startload(String cmd) {
        SmsLoader.setIsLoad(new AtomicBoolean(true));
        return true;
    }

    public static boolean puttpllimit(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 3) {
            return false;
        }
        String tplId = args[1];
        int limit = Integer.parseInt(args[2]);
        FrequentCondition.putTplIdLimitMap(tplId, limit);
        return true;
    }

    public static boolean puttplinterval(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 3) {
            return false;
        }
        String tplId = args[1];
        int interval = Integer.parseInt(args[2]);
        FrequentCondition.putTplIdIntervalMap(tplId, interval);
        return true;
    }

    public static boolean putbizcodelimit(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 3) {
            return false;
        }
        String bizCode = args[1];
        int limit = Integer.parseInt(args[2]);
        FrequentCondition.putBizCodeLimitMap(bizCode, limit);
        return true;
    }

    public static boolean putbizcodeinterval(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 3) {
            return false;
        }
        String bizCode = args[1];
        int interval = Integer.parseInt(args[2]);
        FrequentCondition.putBizCodeIntervalMap(bizCode, interval);
        return true;
    }

    public static Object help(String cmd) {
        StringBuilder sb = new StringBuilder();
        for (Method method : CmdUtil.class.getDeclaredMethods()) {
            sb.append(method.toString().split("CmdUtil.")[1] + "|");
        }
        return sb.toString();
    }

    public static Object reloadsensitiveword(String cmd) {
        SensitiveWordCondition.reloadSensitiveWord();
        return true;
    }

    public static Object updateyxlkchannel(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 2) {
            return false;
        }
        String channel = args[1];
        YXLKSMSChannel.updateChannelNumber(channel);
        return true;
    }

    public static Object addsmswhitemobile(String cmd) {
        String[] args = cmd.split(" ");
        if (args.length != 2) {
            return false;
        }
        String mobile = args[1];
        FrequentCondition.putWhiteMobile(mobile);
        return true;
    }

    public static Object showfrequent(String cmd) {
        return FrequentCondition.showFrequentMap();
    }
    public static void main(String[] args) {
        //第一种方式：
        Class c1 = Class.forName("Employee");
        //第二种方式：
        //java中每个类型都有class 属性.
        Class c2 = Employee.class;

        //第三种方式：
        //java语言中任何一个java对象都有getClass 方法
        Employe ee = new Employee();
        Class c3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee)
        String str = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date().getTime() - 24 * 60 * 60 * 1000);
        System.out.println(str);
    }


}
*/
