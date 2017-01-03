package util;

import com.alibaba.fastjson.JSONObject;
import com.dajie.receiver.client.SendCenterDataServiceContext;
import com.dajie.receiver.data.api.InvitePlanService;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhihaosong on 16-7-27.
 */
public class SendMailReal {

    private static InvitePlanService invitePlanService = SendCenterDataServiceContext.getInstance().getInvitePlanService();

    public static void main(String[] args) {
        String result = invitePlanService.createInvitePlan(1253, false);   //创建邀约计划，本次邀约流程id=1253
        JSONObject resultJsonObject = JSON.parseObject(result);
        Long planId = 0l;
        if (resultJsonObject.getLong("result") == 101) {
            planId = Long.valueOf(resultJsonObject.getLong("message"));
        }
        if (planId > 0) {
            List<Map<String, String>> listBuffer = new ArrayList();
            try {
                int count = 3;
                Map<String, String> map = new HashMap<String, String>();
                map.put("UID", "34105731");              //收件人uid
                map.put("userIdentity", "34105731");     //与收件人uid相同
                map.put("count", count + "");                   //候选人数量
                for (int i = 0; i < count; i++) {
                    map.put("candidate." + i, " 人才姓名１");             //这几个参数为数组
                    map.put("currentCorp." + i, " 当前公司");
                    map.put("currentJob." + i, " 当前职位");
                    map.put("graduSchool." + i, " 毕业院校");
                    map.put("major." + i, " 专业");
                    map.put("workExper." + i, " 工作经验");
                    map.put("uid." + i, "2604530");
                    map.put("jobSeq." + i, "254424");
                }
                listBuffer.add(map);    //每1000个数据一次提交发送
                String sendResult = invitePlanService.sendInvitePlanData(planId, listBuffer);  //获取邀约数据
                String commitResult = invitePlanService.commitInvitePlan(planId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
