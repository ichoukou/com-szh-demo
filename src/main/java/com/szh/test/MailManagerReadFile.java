package com.szh.test;

import com.dajie.mail.MailManagerServicesContext;
import com.dajie.mail.constant.MailTplKeys;
import com.dajie.mail.service.MailManagerService;
import com.sun.org.apache.regexp.internal.RE;
import redis.clients.jedis.JedisCluster;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * * Created by yunbinan on 15-9-29.
 */
public class MailManagerReadFile {
    private static final MailManagerService mailManagerService = MailManagerServicesContext.getInstance().getMailService();

    public static void main(String[] args) {

        Set<String> set = ReadFromFile.readFileByLines("/home/zhihaosong/workspace/com-szh-demo/src/main/resources/1111.txt");

        String sss = "13011060862\n" +
                "13120730799\n" +
                "13151068583\n" +
                "13156882295\n" +
                "13161939468\n" +
                "13162665595\n" +
                "13260014256\n" +
                "13264060195\n" +
                "13269637890\n" +
                "13290180357\n" +
                "13368373676\n" +
                "13372665949\n" +
                "13435607171\n" +
                "13436589963\n" +
                "13480748642\n" +
                "13482330504\n" +
                "13510107601\n" +
                "13522037877\n" +
                "13524654756\n" +
                "13564771865\n" +
                "13564836019\n" +
                "13581544984\n" +
                "13590290799\n" +
                "13593174975\n" +
                "13602448029\n" +
                "13613508561\n" +
                "13626196317\n" +
                "13636555416\n" +
                "13661510235\n" +
                "13671758020\n" +
                "13672061085\n" +
                "13682408072\n" +
                "13691104002\n" +
                "13701374959\n" +
                "13710836722\n" +
                "13761033030\n" +
                "13761387804\n" +
                "13764598031\n" +
                "13775971155\n" +
                "13784326937\n" +
                "13800138000\n" +
                "13808976142\n" +
                "13810006245\n" +
                "13811241717\n" +
                "13812882036\n" +
                "13818320750\n" +
                "13826119192\n" +
                "13865985632\n" +
                "13870012777\n" +
                "13889432570\n" +
                "13912622835\n" +
                "13916135876\n" +
                "13917334839\n" +
                "13917934082\n" +
                "13918650523\n" +
                "13925002140\n" +
                "15011385293\n" +
                "15062238529\n" +
                "15098606025\n" +
                "15110009092\n" +
                "15110036752\n" +
                "15110173309\n" +
                "15120073421\n" +
                "15122042961\n" +
                "15210761015\n" +
                "15210929091\n" +
                "15221359248\n" +
                "15222305097\n" +
                "15247646573\n" +
                "15370666699\n" +
                "15532736471\n" +
                "15542576673\n" +
                "15658057037\n" +
                "15680950436\n" +
                "15692271989\n" +
                "15714116082\n" +
                "15757188616\n" +
                "15800892679\n" +
                "15801572417\n" +
                "15801629446\n" +
                "15810955692\n" +
                "15820212352\n" +
                "15821906567\n" +
                "15833986036\n" +
                "15840906723\n" +
                "15851219761\n" +
                "15915853937\n" +
                "15920495602\n" +
                "15921053506\n" +
                "15921404629\n" +
                "15921816310\n" +
                "15951007393\n" +
                "17600555711\n" +
                "17600890543\n" +
                "18001385727\n" +
                "18092122640\n" +
                "18104328693\n" +
                "18114735970\n" +
                "18132229022\n" +
                "18201114503\n" +
                "18210167825\n" +
                "18217233430\n" +
                "18221777574\n" +
                "18234103407\n" +
                "18249256569\n" +
                "18268082679\n" +
                "18310057365\n" +
                "18310298722\n" +
                "18311049936\n" +
                "18314490952\n" +
                "18320145768\n" +
                "18324530330\n" +
                "18333618239\n" +
                "18363872071\n" +
                "18500336146\n" +
                "18501222591\n" +
                "18511310842\n" +
                "18511437610\n" +
                "18512114485\n" +
                "18513622758\n" +
                "18515250375\n" +
                "18518656610\n" +
                "18562201898\n" +
                "18576448540\n" +
                "18600477507\n" +
                "18600499095\n" +
                "18601219921\n" +
                "18601787167\n" +
                "18602158776\n" +
                "18610651362\n" +
                "18611813932\n" +
                "18611895712\n" +
                "18614256793\n" +
                "18615283570\n" +
                "18621078609\n" +
                "18621755792\n" +
                "18621976763\n" +
                "18640931205\n" +
                "18651906220\n" +
                "18652933553\n" +
                "18658898098\n" +
                "18662156621\n" +
                "18663812428\n" +
                "18664591964\n" +
                "18668981130\n" +
                "18698849069\n" +
                "18701675402\n" +
                "18710095206\n" +
                "18710198828\n" +
                "18718681909\n" +
                "18721195812\n" +
                "18721228020\n" +
                "18764225202\n" +
                "18767197237\n" +
                "18806212854\n" +
                "18826140810\n" +
                "18857873007\n" +
                "18858265394\n" +
                "18911488250\n" +
                "18913513434\n" +
                "18969021341";
     /*   for (String aa : sss.split("\n")) {
            System.out.println(setOperation.sCard("sms_white_mobile"));
            System.out.println(setOperation.sIsMember("sms_white_mobile", aa));
            //  System.out.println(setOperation.sRem("sms_white_mobile", aa));
        }*/
     /*   Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 3; i++) {
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
        }
        map.put("jobname", "java开发");
        map.put(MailTplKeys.KEY_TO_UNAME, "宋先生");
        map.put(MailTplKeys.KEY_TO_UID, "34105731");
        map.put(MailTplKeys.KEY_TO_EMAIL, "1551151530@qq.com");                         //收件人Email
        map.put(MailTplKeys.KEY_TPL_VERSION_ID, "10407");                                      //邮件模板id
        boolean results = mailManagerService.sendNoRealTimeMail(map);

        System.out.println(results);*/
        String mo = "送实施ssAAA";
        mo = mo.toLowerCase();
        System.out.println(mo);
        mo = null;
        mo = mo.toLowerCase();
        System.out.println(mo);
    }
}
