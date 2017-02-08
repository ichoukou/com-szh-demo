package com.szh.condition;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by yunbinan on 16-8-18.
 */
public abstract class AbstractCondition {
    private static Logger logger = LoggerFactory.getLogger(AbstractCondition.class);

    public AbstractCondition nextCondition;

    public boolean judge(String request, List<String> info) {
        try {
            long start = System.nanoTime();
            boolean result = isPass(request);
            info.add(this.getClass().getSimpleName() + "(" + (System.nanoTime() - start) + ")");
            if (result) {
                if (nextCondition == null) {
                    return true;
                }
                return nextCondition.judge(request, info);
            }
        } catch (Exception e) {
            logger.error("AbstractCondition error:{}" + e.getMessage(), e);
        }
        return false;
    }

    /*
    * return true go on
    * return false over
    * */
    public abstract boolean isPass(String request);

    public AbstractCondition getNextCondition() {
        return nextCondition;
    }

    public void setNextCondition(AbstractCondition nextCondition) {
        this.nextCondition = nextCondition;
    }

    @Override
    public String toString() {
        return "AbstractCondition{" +
                "nextCondition=" + nextCondition +
                '}';
    }
}
