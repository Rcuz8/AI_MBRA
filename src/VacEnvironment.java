import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class VacEnvironment {

    Vac_SRA vac;

    public VacEnvironment() {
        vac = new Vac_SRA();
    }

    public List<Integer> generateVacuumPercept(int lastLoc) {
        List<Integer> list = new LinkedList<>();
        int isClean = (new Random().nextInt() < 0.5 ? 0 : 1);
        list.add(lastLoc);
        list.add(isClean);
        return list;
    }

    int moved(int prev, VacAction action) {
        if (prev == 0 && action == VacAction.Right) return 1;
        if (prev == 1 && action == VacAction.Left) return 0;
        return prev;
    }

    public void run_for_n_iterations(int n) {
        int loc = 0; // A
        while (n >  0) {
            List<Integer> percept = generateVacuumPercept(loc);
            VacAction action = vac.REFLEX_VAC_AGENT(percept);
            Pr.pr("{ " + (percept.get(0) == 0 ? "A" : "B") + ", " + (percept.get(1) == 0 ? "CLEAN" : "DIRTY") + " }" + " => " + action.toString());
            loc = moved(loc,action);
            n--;
        }
    }

}

/*
    Percept
 */

//enum VacLoc {
//    A,
//    B,
//    String;
//
//    @Override
//    public java.lang.String toString() {
//        if (this == VacLoc.A) return "A";
//        if (this == VacLoc.B) return "B";
//        return "null";
//    }
//}

//enum VacClean {
//    clean,
//    dirty,
//    String;
//
//    @Override
//    public java.lang.String toString() {
//        if (this == VacClean.clean) return "clean";
//        if (this == VacClean.dirty) return "dirty";
//        return "null";
//    }
//}

//enum VacStates {
//    Aclean,
//    Adirty,
//    Bclean,
//    Bdirty,
//    String;
//
//    @Override
//    public java.lang.String toString() {
//        if (this == VacStates.Aclean) return "Aclean";
//        if (this == VacStates.Adirty) return "Adirty";
//        if (this == VacStates.Bclean) return "Bclean";
//        if (this == VacStates.Bdirty) return "Bdirty";
//        return "null";
//    }
//}
