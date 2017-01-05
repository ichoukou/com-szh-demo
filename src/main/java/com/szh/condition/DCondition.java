package main.java.com.szh.condition;


/**
 * Created by yunbinan on 16-8-18.
 */
@FilterCondition
public class DCondition extends AbstractCondition {
    @Override
    public boolean isPass(String request) {
        System.out.println(this.getClass().getName());
        return true;
    }
    public DCondition() {
        System.out.println("D construction");
    }
}
