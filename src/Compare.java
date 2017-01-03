import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhihaosong on 16-6-27.
 */
public class Compare {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("126") == Integer.valueOf("126"));
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
        System.out.println(Integer.valueOf("129") == Integer.valueOf("129"));
        System.out.println(Integer.parseInt("128") == Integer.valueOf("128"));
        System.out.println(Integer.valueOf("125") == Integer.valueOf("125"));
        System.out.println("=========");
        Integer a1 = new Integer(125);
        Integer a2 = new Integer(125);
        Integer b1 = 125;
        Integer b2 = 125;
        Double.valueOf(123);
        System.out.println(a1 == a2);
        System.out.println(b1 == b2);
        System.out.println("=========");
        Integer x1 = new Integer(129);
        Integer x2 = new Integer(129);
        Integer d1 = 2;
        Integer d2 = null;
        try {
            d2 = 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(x1 == x2);
        System.out.println(d1 == 129);
        System.out.println(129 == d2);
        System.out.println(d1 == x1);
        //System.out.println(sendSmsByGUODUGet("18201090152"));
       /* String result="D5436916060113594300";
        result = result.toLowerCase().substring(0, result.length() - 4);
        System.out.println(result);*/
       /* for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 10) + 1;
            System.out.println(num);
        }*/
       /* Pattern httpPattern = Pattern.compile("\\$\\{([a-zA-Z0-9\\._-]+)\\}");

//        Pattern pattern = Pattern.compile("\\$\\{([0-9A-Za-z]+)\\}");
        String template = "${UNAME}，${corpName}邀请您前往参加面试： ${SHORT_URL(\"http://www.dajie.com${MOBIKE.}\",'${UID}')}";
        Matcher matcher = httpPattern.matcher(template);
        //System.out.println(matcher.find());
        while (matcher.find()) {*/
      /*  Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(12, "sss");

        map.put(111, "sss");
        map.put(222, "sss");
        map.put(333, "sss");
        map.put(555, "sss");
        map.put(9999, "sss");
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer arg0, Integer arg1) {
                return arg1.compareTo(arg0);
            }
        });*/  //
        Pattern smsClickPatten = Pattern.compile("channelcode(=|%3D)(.*?)(&|%26)uid(=|%3D)(\\d*)(&|%26)st(=|%3D)(\\d*)(&|%26)tplId(=|%3D)(\\d*)(&|%26)serialId(=|%3D)([\\w-]*)");
        Matcher smsClickkk = smsClickPatten.matcher("channelcode=MWPT_DAJIE&uid=34348703&st=201603241031&tplId=10016&serialId=djgk032401");

        if (smsClickkk.find()) {
            String channelCode = smsClickkk.group(2);
            String uid = smsClickkk.group(5);
            String st = smsClickkk.group(8);
            String tplId = smsClickkk.group(11);
            String serialId = smsClickkk.group(14);
            System.out.println(smsClickkk.find() + "\t" + channelCode + "\t" + uid + "\t" + st + "\t" + tplId + "\t" + serialId.trim() + " 1233");
        }
        // System.out.println(smsClickkk.find() + "\t" + smsClickkk.group(2) + "\t" + smsClickkk.group(5) + "\t" + smsClickkk.group(8) + "\t" + smsClickkk.group(11) + "\t" + smsClickkk.group(14));

        //   System.out.println(smsClick.find() + "\t" + channelCode + "\t" + uid + "\t" + st + "\t" + tplId + "\t" + serialId);
        String res = "http://d-j.me/xSNMWG5";
        res = res.substring(res.indexOf("d-j.me"));
        System.out.println(String.valueOf(res));

        // Map<String, String> map=new HasehMap<String, String>();
        //  map.put(DefaultTplKey.MOBILE.getKey(), "18201090152");    //手机号
        // map.put("securitycode","19999");
        // map.put("CHANNEL_CODE","GD_TALENT_REAL");
        // map.put(DefaultTplKey.BUSINESS_SERIAL_ID.getKey(),"bm0506002");
        // SmsResponse smsResponse = smsService.sendSMS(3000, 10032, map);//模板号
        // String result = smsResponse.getResult();
        // System.out.println(String.valueOf(result));
        Map map = new HashMap();
        map.hashCode();
        try {
            map.equals(new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map2 = new ConcurrentHashMap();
    }
}
