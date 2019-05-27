import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// String = String/Int
public class NFA {

    List<State> states;
    List<Character> input_alphabet;
    Table<List<State>> transition_table;
    State initial_state;
    List<State> accepting_states;

    List<State> current_states;

        // M = < States, Inputs, Stringr Stringable, Init. State , Final States >
    public NFA(List<State> states, List<Character> input_alphabet, Table<List<State>> transition_table, State initial_state, List<State> accepting_states) {
        this.states = states;
        this.input_alphabet = input_alphabet;
        this.transition_table = transition_table;
        this.initial_state = initial_state;
        this.accepting_states = accepting_states;
        this.current_states = new LinkedList<>();
        current_states.add(State.clone(initial_state));
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

        this.transition_table.get(src_index,sym_index).add(dst);
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
    List<State> get_transition_list(State src, char sym) {
        int src_index = states_indexOf(src);
        int sym_index = input_alphabet.indexOf(sym);
        List<State> l = (this.transition_table.get(src_index,sym_index));
        return l;
    }

    public static NFA new_quick_nfa(int n_states) {
        List<State> states = State.list_numbered_states_from_zero(n_states);

        List<Character> input_alphabet = new ArrayList<>();
        for (int c=32; c<128; c++) {
           input_alphabet.add((char)c);
        }
        Table<List<State>> transition_table = new Table<List<State>>(n_states,input_alphabet.size());
        State initial_state = new State("0");
        List<State> accepting_states = new ArrayList<>();
        accepting_states.add(new State(String.valueOf(n_states-1)));
        return new NFA(states,input_alphabet,transition_table,initial_state,accepting_states);
    }

    public void print_status(String input, State current_state) {
        Pr.pr("STATUS:  " + (current_state != null ? current_state.get() : null) + " + (" + input + ")");
    }

    boolean run(String input) {

        this.transition_table.print_asStateTable();

        boolean did_not_finish = false;

        while (!input.isEmpty()) {

            List<State> new_states = new LinkedList<>();

            for (State current_state: current_states) {

                print_status(input, current_state);

                // pop next char
                char next_letter = input.charAt(0);
                input = input.substring(1);

                List<State> incoming = this.get_transition_list(current_state,next_letter);
                for (State inc_st:incoming) {
                    if (!new_states.contains(inc_st)) new_states.add(inc_st);
                }
            }

            current_states = new_states;

        }

        boolean ended_in_accepting = false;

        for (State s: current_states) {
            if (accepting_states.contains(s)) ended_in_accepting = true;
        }

        this.current_states = new LinkedList<>();
        current_states.add(State.clone(initial_state));

        return ended_in_accepting;

    }

    void advance(char next_letter) {

        List<State> new_states = new LinkedList<>();

        for (State current_state: current_states) {

            List<State> incoming = this.get_transition_list(current_state,next_letter);
            for (State inc_st:incoming) {
                if (!new_states.contains(inc_st)) new_states.add(inc_st);
            }
        }

        current_states = new_states;

    }

}
