import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

public abstract class SRA<A> {

    // One list per input
    Table<String> percepts_table;

    /*
        "Persistent"
     */

    List<Rule<A>> rules;

    SRA(Table<String> percepts_table, List<Rule<A>> rules) {
        this.percepts_table = percepts_table;
        this.rules = rules;
    }

    // For initialization later
    SRA() {
        this.percepts_table = null;
        this.rules = null;
    }

    A SIMPLE_REFLEX_AGENT(List<Integer> percepts) {
        State state = INTERPRET_INPUT(percepts);
        Rule<A> rule = RULE_MATCH(state,rules);
        A action = rule != null ? ((A) rule.action) : null;
        return action;
    }

    /*
        Generate abstract representation of state
     */

    protected State INTERPRET_INPUT(List<Integer> percepts) {
        Str val = new Str("");
        int row = 0;
        for (Integer perc:percepts) {
            val.a(percepts_table.get(row,perc));
            row++;
        }
        // concatenate all percept factors to one state value
        return new State(val.stringVal());
    }

    protected Rule RULE_MATCH(State state, List<Rule<A>> rules) {
        for (Rule rule: rules) {
            if (rule.check(state)) return rule;
        }
        return null;
    }

}
