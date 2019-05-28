import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

public class Vac_SRA extends SRA<VacAction> {

    Vac_SRA() {
        this.percepts_table = new Table<String>(2,2);
        LinkedList<String> loc = new LinkedList<>();
        loc.add("A");
        loc.add("B");
        LinkedList<String> isDirty = new LinkedList<>();
        isDirty.add("Clean");
        isDirty.add("Dirty");
        this.percepts_table.setList(0,loc);
        this.percepts_table.setList(1,isDirty);
        this.addRules();
    }

    private void addRules() {
        rules = new LinkedList<>();
        //  Clean
        rules.add(new Rule<VacAction>(new State(this.percepts_table.get(0,0)+this.percepts_table.get(1,0)),VacAction.Right));
        rules.add(new Rule<VacAction>(new State(this.percepts_table.get(0,1)+this.percepts_table.get(1,0)),VacAction.Left));
        //  Dirty
        rules.add(new Rule<VacAction>(new State(this.percepts_table.get(0,0)+this.percepts_table.get(1,1)),VacAction.Suck));
        rules.add(new Rule<VacAction>(new State(this.percepts_table.get(0,1)+this.percepts_table.get(1,1)),VacAction.Suck));
    }

    VacAction REFLEX_VAC_AGENT(List<Integer> percepts) {
        return super.SIMPLE_REFLEX_AGENT(percepts);
    }

}

enum VacAction {
    Suck,
    Right,
    Left,
    None
}