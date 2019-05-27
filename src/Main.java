import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static DFA dfa_x11()  {
        DFA dfa = DFA.new_quick_dfa(3);
        dfa.set_lambda_transition(dfa.states.get(0),dfa.states.get(0));
        dfa.set_transition(dfa.states.get(0),'1', dfa.states.get(1));
        dfa.set_transition(dfa.states.get(1),'0', dfa.states.get(0));
        dfa.set_transition(dfa.states.get(1),'1', dfa.states.get(2));
        dfa.set_transition(dfa.states.get(2),'0', dfa.states.get(0));
        dfa.set_transition(dfa.states.get(2),'1', dfa.states.get(1));
        return dfa;
    }

    public static void dfa_test() {
        DFA d = dfa_x11();
        Pr.pr(d.run("000101011"));

    }

    public static void main(String[] args) {

        List<Boolean> inputs =  new LinkedList<Boolean>();
        Boolean i1 = new Boolean(true);
        Boolean i2 = new Boolean(true);
        inputs.add(i1);
        inputs.add(i2);

        List<Gate> gates = new LinkedList<>();
        Gate g1 = new Gate_OR();
        Gate g2 = new Gate_NOT();
        Gate g3 = new Gate_NOT();
        Gate g4 = new Gate_NOT();

        gates.add(g1);
        gates.add(g2);
        gates.add(g3);
        gates.add(g4);

        List<Integer> outs = new LinkedList<>();
        outs.add(3);

        Circuit c = new Circuit(inputs,gates,outs);

        c.conn(i1,g1,0);
        c.conn(i2,g1,1);

        c.conn_out_to_in(g1,g2,0);
        c.conn_out_to_in(g2,g3,0);
        c.conn_out_to_in(g3,g4,0);

        Pr.pr(c.evaluate());

    }


}
