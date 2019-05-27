import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class MBRA {

    /*
        Persistent
     */

    State state;

    Action action;

    List<Rule> rules;

    DFA model; // table w/ advance()


    Action MODEL_BASED_REFLEX_AGENT(Percept percept) {
        state = UPDATE_STATE(state,action,percept,rules);
        Rule rule = RULE_MATCH(state,rules);
        action = rule.action;
        return action;
    }

//    boolean gotBurned(State prev_state) {
//        if (prev_state.get().equals(Percept.first_10.toString()))
//    }

    State UPDATE_STATE(State s, Action a, Percept p, List<Rule> rules) {

        return new State("idkk");
    }

    Rule RULE_MATCH(State state, List<Rule> rules) {
        /* if state is ... , do ...    */
        return new Rule(new State("idkk"),Action.Blitz);
    }

}


enum Percept {
    first_10,
    second_10,
    second_5,
    third_5,
    third_10,
    fourth_3,

    String;

    @Override
    public java.lang.String toString() {
        if (this == Percept.first_10) return "first_10";
        if (this == Percept.second_10) return "second_10";
        if (this == Percept.second_5) return "second_5";
        if (this == Percept.third_5) return "third_5";
        if (this == Percept.third_10) return "third_10";
        if (this == Percept.fourth_3) return "fourth_3";
        return "null";
    }
}

enum Action {
    Blitz,
    cover_2,
    Cover_3
}