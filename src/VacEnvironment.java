import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class VacEnvironment {

    Vac_SRA_ex vac;

    public VacEnvironment() {
        vac = new Vac_SRA_ex();
    }

    public Perc generateVacuumPercept(VacLoc lastLoc) {
        List<String> list = new LinkedList<>();
        String isDirty = (new Random().nextInt() < 0.5 ? "clean" : "dirty");
        list.add(lastLoc.toString());
        list.add(isDirty);
        return new Perc(list);
    }

//    public LinkedList<Perc> percsList(int n) {
//        List<String> list = new LinkedList<>();
//        VacLoc initialLoc
//        while (n > 0) {
//            list.add(generateVacuumPercept())
//        }
//    }

    VacLoc moved(VacLoc prev, VacAction action) {
        if (prev == VacLoc.A && action == VacAction.Right) return VacLoc.B;
        if (prev == VacLoc.B && action == VacAction.Left) return VacLoc.A;
//        if (action == VacAction.None || action == VacAction.Suck) return prev;
        return prev;
    }

    public void run_for_n_iterations(int n) {
        VacLoc loc = VacLoc.A;
        while (n >  0) {
            Perc percept = generateVacuumPercept(loc);
            VacAction action = vac.REFLEX_VAC_AGENT(percept);
            Pr.pr("{ " + loc.toString() + ", " + percept.strVal.stringVal().substring(1) + "}" + " => " + action.toString());
            loc = moved(loc,action);
            n--;
        }
    }

}
