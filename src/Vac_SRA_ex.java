import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

public class Vac_SRA_ex {

    /*
        Persistent
     */

    List<VacRule> rules;

    Vac_SRA_ex() {
        this.addRules();
    }

    private void addRules() {
        rules = new LinkedList<>();
        rules.add(new VacRule(new State(VacStates.Aclean.toString()),VacAction.Right));
        rules.add(new VacRule(new State(VacStates.Bclean.toString()),VacAction.Left));
        rules.add(new VacRule(new State(VacStates.Adirty.toString()),VacAction.Suck));
        rules.add(new VacRule(new State(VacStates.Bdirty.toString()),VacAction.Suck));
    }

    VacAction REFLEX_VAC_AGENT(Perc percept) {
        State state = INTERPRET_INPUT(percept);
        VacRule rule = RULE_MATCH(state,rules);
        VacAction action = rule != null ? rule.action : VacAction.None;
        return action;
    }

    /*
        Generate abstract representation of state
     */

    private State INTERPRET_INPUT(Perc p) {
        // concatenate all percept factors to one state value
        return new State(p.strVal.stringVal());
    }

    private VacRule RULE_MATCH(State state, List<VacRule> rules) {
        for (VacRule rule: rules) {
            if (rule.check(state)) return rule;
        }
        return null;
    }

}

/*
    Percept
 */

enum VacLoc {
    A,
    B,
    String;

    @Override
    public java.lang.String toString() {
        if (this == VacLoc.A) return "A";
        if (this == VacLoc.B) return "B";
        return "null";
    }
}

enum VacClean {
    clean,
    dirty,
    String;

    @Override
    public java.lang.String toString() {
        if (this == VacClean.clean) return "clean";
        if (this == VacClean.dirty) return "dirty";
        return "null";
    }
}

enum VacStates {
    Aclean,
    Adirty,
    Bclean,
    Bdirty,
    String;

    @Override
    public java.lang.String toString() {
        if (this == VacStates.Aclean) return "Aclean";
        if (this == VacStates.Adirty) return "Adirty";
        if (this == VacStates.Bclean) return "Bclean";
        if (this == VacStates.Bdirty) return "Bdirty";
        return "null";
    }
}

enum VacAction {
    Suck,
    Right,
    Left,
    None
}