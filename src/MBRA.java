import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public abstract class MBRA<A> {

    // One list per input
    Table<String> percepts_table;

    /*
        Persistent
     */

    State state;

    A action;

    List<Rule<A>> rules;

    /*
        We need to extend the circuit class to be able to
        execute logic on non-boolean objects.

        Ex. Usage for vacuum: -> "best guess" at guessing where to go next

        Circuit:

        EQ (State.val() , "Aclean") => move
        EQ (State.val() , "Bclean") => 50% chance of moving
        EQ (State.val() , "Adirty") => move
        EQ (State.val() , "Bclean") => 50% chance of moving

     */

    public MBRA(Table<String> percepts_table, List<Rule<A>> rules) {
        this.percepts_table = percepts_table;
        this.rules = rules;
        this.state = null;
        this.action = null;
    }

    public MBRA()  {
        this.percepts_table = null;
        this.rules = null;
    }


    A MODEL_BASED_REFLEX_AGENT(List<Integer> percepts) {
        state = UPDATE_STATE(percepts);
        Rule<A> rule = RULE_MATCH(state,rules);
        A action = rule != null ? ((A) rule.action) : null;
        return action;
    }

    /**
     *
     * Generate the model circuit given the inputs below.
     *
     * Should include a template circuit that uses the percepts and state as inputs
     * to generate one single optimal output state
     *
     * @param st the prev state
     * @param action the prev action
     * @param percepts the list of current percept indices
     * @return the generated circuit
     */
    abstract Circuit<State> gen_model(State st, A action, List<Integer> percepts);

    /*
        Generate abstract representation of state
     */

    protected State UPDATE_STATE(List<Integer> percepts) {
        State new_state = gen_model(this.state,this.action,percepts).evaluate().get(0);
        return new_state;
    }

    protected Rule RULE_MATCH(State state, List<Rule<A>> rules) {
        for (Rule rule: rules) {
            if (rule.check(state)) return rule;
        }
        return null;
    }

}

//
//enum Percept {
//    first_10,
//    second_10,
//    second_5,
//    third_5,
//    third_10,
//    fourth_3,
//
//    String;
//
//    @Override
//    public java.lang.String toString() {
//        if (this == Percept.first_10) return "first_10";
//        if (this == Percept.second_10) return "second_10";
//        if (this == Percept.second_5) return "second_5";
//        if (this == Percept.third_5) return "third_5";
//        if (this == Percept.third_10) return "third_10";
//        if (this == Percept.fourth_3) return "fourth_3";
//        return "null";
//    }
//}
//
//enum Action {
//    Blitz,
//    cover_2,
//    Cover_3
//}