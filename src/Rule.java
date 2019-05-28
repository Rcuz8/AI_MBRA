public class Rule<A> {

    State val;

    A action;

    public Rule(State val, A action) {
        this.val = val;
        this.action = action;
    }

    boolean check(State a_state) {
        return val.equals(a_state);
    }
}



