package main.java.com.szh.util;

import testLIst.PrivilegeType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * 日期工具类
 */
public class DateAndTimeUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat simpleDateFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期月份减一个月
     */
    public static String dateFormat(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.MONTH, -1);
        date = cl.getTime();
        return sdf.format(date);
    }

    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }

    /**
     * 日期加3天
     */
    public static String DateAdd3Days(String _date) {
        Calendar cl = Calendar.getInstance();
        Date date = null;
        try {
            date = (Date) simpleDateFormat.parse(_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_YEAR, 3);
        date = cl.getTime();
        return simpleDateFormat.format(date);
    }

    /**
     * 日期加3天
     */
    public static String DateAdd3Days(Date _date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(_date);
        cl.add(Calendar.DAY_OF_YEAR, 3);
        _date = cl.getTime();
        return simpleDateFormat_.format(_date);
    }


    public static String DateAddSubDays(Date _date, int sums) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(_date);
        cl.add(Calendar.DAY_OF_YEAR, 0 - sums);
        _date = cl.getTime();
        return simpleDateFormat_.format(_date);
    }
    public static int getSum(String sums) {
        int result = 0;
        String[] num = sums.split(",");
        for (int i = 0; i < num.length; i++) {
            result = result + Integer.parseInt(num[i]);
        }
        return result;
    }

    public static int getSums(String sums) {
        int result = 0;
        String[] types = sums.split(",");
        for (int i = 0; i < types.length; i++) {
            int type = Integer.parseInt(types[i]);
            if (type == PrivilegeType.JOB_UP_LIMIT_X5.getId())
                result = result + PrivilegeType.JOB_UP_LIMIT_X5.getNum();
            else
                result = result + PrivilegeType.JOB_UP_LIMIT_X1.getNum();
        }
        return result;
    }
    public static void main(String[] args) throws ParseException {
        String str = null;
        System.out.println(new Date());
        System.out.println(DateAddSubDays(new Date(), 1));
        System.out.println(getSums("7"));
        Properties properties =new Properties();

    }
}