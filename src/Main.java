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

    /*
        NOT( NOT ( OR( x, y ) ) )

     */
    public static void test_bool_circuit() {
        List<Boolean> inputs =  new LinkedList<Boolean>();
        Boolean i1 = null;
        Boolean i2 = null;
        inputs.add(i1);
        inputs.add(i2);

        List<Gate<Boolean>> gates = new LinkedList<>();
        Gate<Boolean> g1 = new Gate_OR<Boolean>(new Boolean(true));
        Gate<Boolean> g2 = new Gate_NOT<Boolean>(new Boolean(true));
        Gate<Boolean> g3 = new Gate_NOT<Boolean>(new Boolean(true));

        gates.add(g1);
        gates.add(g2);
        gates.add(g3);

        List<Integer> outs = new LinkedList<>();
        outs.add(gates.size()-1);

        Circuit<Boolean> c = new Circuit<Boolean>(inputs,gates,outs);

        c.conn(i1,g1,0);
        c.conn(i2,g1,1);

        c.conn_out_to_in(g1,g2,0);
        c.conn_out_to_in(g2,g3,0);

        List<Boolean> l = c.evaluate();

        Pr.prArr(l);
    }

    static void Gate_pr(Gate<State> g) {
        State s = g.evaluate();
        if (s != null)
            Pr.pr(s.get());
        else Pr.pr("null");
    }

    /*
        (A or C) x 70% AND NOT( B x 20% ) => .7 x .8 = .56 (Ptrue)
     */

    public static String test_obj_circuit_adv() {
        List<State> inputs =  new LinkedList<State>();
        State i1 = new State("A_st");
        State i2 = new State("B_st");
        State i3 = new State(null);
        inputs.add(i1);
        inputs.add(i2);
        inputs.add(i3);

        State failsafe = new State("|FS|");

        List<Gate<State>> gates = new LinkedList<>();
        Gate<State> g1 = new Gate_OR<State>(i1,i3,i1); // good
//        Pr.pr(1);
//        System.out.print("(A*) g1: ");Gate_pr(g1);
        Gate<State> g2 = new Gate_P<State>(g1.evaluate(),failsafe, 0.7); // good
//        Pr.pr(2);
//        System.out.print("(A?) g2: ");Gate_pr(g2);
        Gate<State> g3 = new Gate_P<State>(i2,failsafe, 0.2);
//        Pr.pr(3);
//        System.out.print("(N?) g3: ");Gate_pr(g3);
        Gate<State> g4 = new Gate_NOT<State>(g3.evaluate(),i2);
//        System.out.print("(B?) g4: ");Gate_pr(g4);
        Gate<State> g5 = new Gate_AND<State>(g2.evaluate(),g4.evaluate(), new State("TRUE"));
//        System.out.print("(X?) g5: ");Gate_pr(g5);

        gates.add(g1);
        gates.add(g2);
        gates.add(g3);
        gates.add(g4);
        gates.add(g5);

        List<Integer> outs = new LinkedList<>();
        outs.add(gates.size()-1);

        Circuit<State> c = new Circuit<State>(inputs,gates,outs);

        List<State> l = c.evaluate();

        return (State) l.get(0) != null ? ((State) l.get(0)).get() : null;
    }

    static void test_adv_circuit() {
        int n = 0;
        for (int i = 0; i < 10000; i++) {
            if (test_obj_circuit_adv() != null)
                n++;

        }
        Pr.pr(n); // Should be ~56% of total
    }

    static void testVac() {
        new VacEnvironment().run_for_n_iterations(10);
    }

    public static void main(String[] args) {
        test_bool_circuit();
    }


}
