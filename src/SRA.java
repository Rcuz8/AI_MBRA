import java.util.List;

public class SRA {


    /*
        Persistent
     */

    State state;

    Action action;

    List<Rule> rules; // Checks states

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
        return new Rule(new Tuple<Boolean>(true,false),Action.Blitz);
    }
}
