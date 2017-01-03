package szh.condition;


/**
 * Created by yunbinan on 16-8-18.
 */
public abstract class AbstractCondition {
    public AbstractCondition nextCondition;

    public boolean judge(String request) {
        if (isPass(request)) {
            return nextCondition.judge(request);
        } else {
            return false;
        }
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
