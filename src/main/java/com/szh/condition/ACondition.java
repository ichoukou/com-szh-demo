package com.szh.condition;


/**
 * Created by yunbinan on 16-8-18.
 */
@FilterCondition
public class ACondition extends AbstractCondition {
    @Override
    public boolean isPass(String request) {
        System.out.println(this.getClass().getName());
        return true;
    }

    public void song() {
        System.out.println("我是a son");
    }
    public ACondition() {
        System.out.println("A construction");
    }
}
