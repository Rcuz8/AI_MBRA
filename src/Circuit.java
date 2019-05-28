import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Circuit<T> {

    List<T> inputs;
    List<Gate<T>> gates;
    List<Integer> output_gate_indices;

//    NFA map; //  may pose a problem bc I need this to be a map of gates, not states..

    public Circuit(List<T> inputs, List<Gate<T>> gates, List<Integer> output_gate_indices) {
        this.inputs = inputs;
        this.gates = gates;
        this.output_gate_indices = output_gate_indices;
//        this.map = NFA.new_quick_nfa(gates.size()+inputs.size());
    }

    public void conn_out_to_in(Gate a, Gate b, int slot) {
        int b_index = gates.indexOf(b);
        if (slot == 0)
            gates.get(b_index).a = (T) a.evaluate();
        if (slot == 1)
            gates.get(b_index).b = (T) a.evaluate();
    }

    public void conn(T a, Gate b, int slot) {
        int b_index = gates.indexOf(b);
        if (slot == 0)
            gates.get(b_index).a = a;
        if (slot == 1)
            gates.get(b_index).b = a;
    }

    public List<T> evaluate() {
        List<T> outs= new ArrayList<>();
        for (Integer i: output_gate_indices) {
            outs.add(gates.get(i).evaluate());
        }
        return outs;
    }

    public static Circuit new_Circuit_nonnullObject(Object o) {
        List<Boolean> inputs =  new LinkedList<Boolean>();
        Boolean i1 = new Boolean(o == null);
        inputs.add(i1);

        List<Gate<Boolean>> gates = new LinkedList<>();
        Gate g4 = new Gate_NOT(new Boolean(true));

        gates.add(g4);

        List<Integer> outs = new LinkedList<>();
        outs.add(0);

        Circuit<Boolean> c = new Circuit<Boolean>(inputs,gates,outs);

        c.conn(i1,g4,0);

        return c;
    }

}
