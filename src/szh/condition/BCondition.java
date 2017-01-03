package szh.condition;


/**
 * Created by yunbinan on 16-8-18.
 */
@FilterCondition
public class BCondition extends AbstractCondition {
    @Override
    public boolean isPass(String request) {
        System.out.println(this.getClass().getName());
        return true;
    }
    public BCondition() {
        System.out.println("B construction");
    }
}
