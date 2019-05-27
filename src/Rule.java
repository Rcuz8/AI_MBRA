public class Rule {

    State val;

    Action action;

    public Rule(State val, Action action) {
        this.val = val;
        this.action = action;
    }

    boolean check(State a_state) {
        return val.equals(a_state);
    }

}


