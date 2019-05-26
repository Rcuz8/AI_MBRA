import java.util.ArrayList;

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
        dfa_test();

    }


}
