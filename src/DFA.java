import java.util.ArrayList;
import java.util.List;

// String = String/Int
public class DFA {

    List<State> states;
    List<Character> input_alphabet;
    Table transition_table;
    State initial_state;
    List<State> accepting_states;

    State current_state;

        // M = < States, Inputs, Stringr Stringable, Init. State , Final States >
    public DFA(List<State> states, List<Character> input_alphabet, Table transition_table, State initial_state, List<State> accepting_states) {
        this.states = states;
        this.input_alphabet = input_alphabet;
        this.transition_table = transition_table;
        this.initial_state = initial_state;
        this.accepting_states = accepting_states;
        this.current_state = State.clone(initial_state);
    }

    int get_state_with_value(String t){
        int i = 0;
        for (State s: states) {
            if (s.get().equals(t)) return i;
        }
        return -1;
    }

    /**
     * For the given DFA, set the transition from state src on input symbol
     * sym to be the state dst.
     */
    void set_transition(State src, char sym, State dst) {
        int src_index = states.indexOf(src);
        int sym_index = input_alphabet.indexOf(sym);

        this.transition_table.set(src_index,sym_index,dst);
    }

    /**
     * For the given DFA, set the transition from state src on input symbol
     * sym to be the state dst.
     */
    void set_lambda_transition(State src, State dst) {
        for (Character c : input_alphabet) {
            this.set_transition(src,c,dst);
        }
    }

    int states_indexOf(State src) {
        int i = 0;
        for (State s: this.states) {
            if (src.equals_state(s)) return i;
            i++;
        }
        return -1;
    }


    /**
     * For the given DFA, set the transition from state src on input symbol
     * sym to be the state dst.
     */
    State get_transition(State src, char sym) {
        int src_index = states_indexOf(src);
        int sym_index = input_alphabet.indexOf(sym);
//        Pr.pr("GETTING ["+src_index+", " + sym_index + "]");
        State s = ((State)this.transition_table.get(src_index,sym_index));
//        if (s == null)
//            return null;
        return s;
    }

    public static DFA new_quick_dfa(int n_states) {
        List<State> states = State.list_numbered_states_from_zero(n_states);

        List<Character> input_alphabet = new ArrayList<>();
        for (int c=32; c<128; c++) {
           input_alphabet.add((char)c);
        }
        Table transition_table = new Table(n_states,input_alphabet.size());
        State initial_state = new State("0");
        List<State> accepting_states = new ArrayList<>();
        accepting_states.add(new State(String.valueOf(n_states-1)));
        return new DFA(states,input_alphabet,transition_table,initial_state,accepting_states);
    }

    public void print_status(String input) {
//        Pr.pr("STATUS:   (" + input + ") => " + (current_state != null ? current_state.get() : null));
        Pr.pr("STATUS:  " + (current_state != null ? current_state.get() : null) + " + (" + input + ")");

    }

    boolean run(String input) {

        this.transition_table.print_asStateTable();

        boolean did_not_finish = false;

        while (!input.isEmpty()) {

            print_status(input);

            // pop next char
            char next_letter = input.charAt(0);
            input = input.substring(1);

            if (current_state == null) {
                did_not_finish = true;
                break;
            }

            current_state = this.get_transition(current_state,next_letter);

        }



        boolean passed = !did_not_finish && (accepting_states.contains(current_state));

        current_state = State.clone(initial_state);

        return passed;

    }

    void advance(char next_letter) {
        current_state = this.get_transition(current_state,next_letter);
    }

}
