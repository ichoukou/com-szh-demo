package hbresponse;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.math.NumberUtils;

public class ReceiveServlet {

    private static final long serialVersionUID = 0x1L;

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

    public static String getSmsReceiver(String dc, String str) {
        int type = NumberUtils.toInt(dc);
        return decodeMessage(type, decodeBytes(str));
    }

    public static Map<String, String> getResponseCode(String str) throws ParseException {
        Map<String, String> params = new HashMap<String, String>();
        try {
          /*  String[] keyVal = str.split("\t");
            params.put("sa", keyVal[0]);
            params.put("result", keyVal[1]);*/

            for (String para : str.split("&")) {
                if (para != null && para.contains("=")) {
                    String[] keyVal = para.split("=");
                    if (keyVal[0].equals("sm")) {
                        params.put(keyVal[0], keyVal[1]);
                    } else
                        params.put(keyVal[0], keyVal[1]);
                }
            }
            if (params.get("dd") == null || "".equals(params.get("dd"))) {
                params.put("dd", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    public static Set<String> getAllMObile() {
        Set<String> allMObile = new HashSet<String>();
        String path = "/home/zhihaosong/workspace/com-szh-demo/src/hbresponse/initdata.txt";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                allMObile.add(tempString);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return allMObile;
    }

    public static Map<String, String> getAllResponse() {
        Map<String, String> allResponse = new HashMap<String, String>();
        String path = "/home/zhihaosong/workspace/com-szh-demo/src/hbresponse/smsmo.txt";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                Map<String, String> params = getResponseCode(tempString);
                String mobile = params.get("sa");
                String result = mobile + "\t" + getSmsReceiver(params.get("dc"), params.get("sm")) + "\n";
                if (allResponse.containsKey(mobile)) {
                    allResponse.put(mobile + " ", mobile + "\t" + result);
                    // allResponse.put(mobile, allResponse.get(mobile).substring(0,allResponse.get(mobile).length()-1) + " " + getSmsReceiver(params.get("dc"), params.get("sm")) + "\n");
                    System.out.println(allResponse.get(mobile) + "去重" + result);
                } else allResponse.put(mobile, mobile + "\t" + result);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return allResponse;
    }

    public static void wirteFile(String result) {
        File wirtefile = new File("/home/zhihaosong/workspace/com-szh-demo/src/hbresponse/smsResponseResult.txt");
        try {
            if (!wirtefile.exists()) {
                wirtefile.createNewFile();
            }
            FileWriter fw = new FileWriter(wirtefile.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Map<String, String> allMobile = getAllResponse();
        for (Map.Entry<String, String> mobile : allMobile.entrySet()) {
            System.out.println(mobile.getValue());
        }
     /*   Set allMobile = getAllMObile();
        Map<String, String> allresponse = getAllResponse();
        System.out.println(allMobile.size() + "\t" + allresponse.size() + "\n==========其他上行报告==========\n");
        for (Map.Entry<String, String> entry : allresponse.entrySet()) {
            if (allMobile.contains(entry.getKey().trim()))
                wirteFile(entry.getValue());
            else
                System.out.println(entry.getValue());
        }
*/
    }
}