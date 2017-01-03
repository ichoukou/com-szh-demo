package szh.condition;


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

    public ACondition() {
        System.out.println("A construction");
    }
}
