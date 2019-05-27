import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Circuit {

    List<Boolean> inputs;
    List<Gate> gates;
    List<Integer> output_gate_indices;

//    NFA map; //  may pose a problem bc I need this to be a map of gates, not states..

    public Circuit(List<Boolean> inputs, List<Gate> gates, List<Integer> output_gate_indices) {
        this.inputs = inputs;
        this.gates = gates;
        this.output_gate_indices = output_gate_indices;
//        this.map = NFA.new_quick_nfa(gates.size()+inputs.size());
    }

    public void conn_out_to_in(Gate a, Gate b, int slot) {
        int b_index = gates.indexOf(b);
        if (slot == 0)
            gates.get(b_index).a = a.evaluate();
        if (slot == 1)
            gates.get(b_index).b = a.evaluate();
    }

    public void conn(Boolean a, Gate b, int slot) {
        int b_index = gates.indexOf(b);
        if (slot == 0)
            gates.get(b_index).a = a;
        if (slot == 1)
            gates.get(b_index).b = a;
    }

    public List<Boolean> evaluate() {
        List<Boolean> outs= new ArrayList<>();
        for (Integer i: output_gate_indices) {
            outs.add(gates.get(i).evaluate());
        }
        return outs;
    }

    public static Circuit new_Circuit_nonnullObject(Object o) {
        List<Boolean> inputs =  new LinkedList<Boolean>();
        Boolean i1 = new Boolean(o == null);
        inputs.add(i1);

        List<Gate> gates = new LinkedList<>();
        Gate g4 = new Gate_NOT();

        gates.add(g4);

        List<Integer> outs = new LinkedList<>();
        outs.add(0);

        Circuit c = new Circuit(inputs,gates,outs);

        c.conn(i1,g4,0);

        return c;
    }












    public List<Boolean> getInputs() {
        return inputs;
    }

    public void setInputs(List<Boolean> inputs) {
        this.inputs = inputs;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<Integer> getOutput_gate_indices() {
        return output_gate_indices;
    }

    public void setOutput_gate_indices(List<Integer> output_gate_indices) {
        this.output_gate_indices = output_gate_indices;
    }

}
