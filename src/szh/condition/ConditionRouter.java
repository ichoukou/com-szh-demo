package szh.condition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by yunbinan on 16-8-18.
 */
public class ConditionRouter implements InitializingBean {

    private AbstractCondition header = null;
    private AbstractCondition current = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(FilterCondition.class); // 获取所有带有 FilterCondition 注解的 Spring Bean
        for (Object serviceBean : serviceBeanMap.values()) {
            Class classzz = serviceBean.getClass();
            try {
                AbstractCondition abstractCondition = (AbstractCondition) classzz.newInstance();
                if (header == null) {
                    header = abstractCondition;
                }
                if (current != null) {
                    current.setNextCondition(abstractCondition);
                }
                current = abstractCondition;
                System.out.println(current.getClass().getName() + " next ");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (header.judge(new String())) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

    public boolean startJudge(String sms) {
        return header.judge(sms);
    }

    public static void main(String[] args) {
        ApplicationContext cfg = new ClassPathXmlApplicationContext("spring-server.xml");
        ConditionRouter conditionRouter = (ConditionRouter) cfg.getBean("ConditionRouter");
    }

}
