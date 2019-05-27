public class VacRule {

    State val;

    VacAction action;

    public VacRule(State val, VacAction action) {
        this.val = val;
        this.action = action;
    }

    boolean check(State a_state) {
        return val.equals(a_state);
    }
}
