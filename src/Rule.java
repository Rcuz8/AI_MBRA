public class Rule {

    Tuple<Boolean> values;

    Action action;

    public Rule(Tuple<Boolean> values, Action action) {
        this.values = values;
        this.action = action;
    }

    public Tuple<Boolean> getValues() {
        return values;
    }

    public void setValues(Tuple<Boolean> values) {
        this.values = values;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}


