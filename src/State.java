import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class State implements Cloneable,Comparable {
    private String val;
    public State(String t) { this.val = t; }
    public String get() { return val; }
    public void set(String t) { val = t; }
    public boolean equals_state(State s) {
        return (val.equals(s.val));
    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {
        return val.compareTo(((State) o).get()) == 0;
    }

        public static State clone(State s) {
        return new State(new String(s.get()));
    }

    public static List<State> list_numbered_states_from_zero(int n) {
        List<State> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new State(String.valueOf(i)));
        }
        return list;
    }


    @Override
    public int compareTo(Object o) {
        return val.compareTo(((State) o).get());
    }
}
