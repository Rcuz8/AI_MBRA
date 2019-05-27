import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pr {

    static void prr(Object o) {System.out.print(o);}
    static void pr(Object o) {System.out.println(o);}
    static void pr(int o) {System.out.println(o);}
    static void pr(double o) {System.out.println(o);}
    static void prArr(List a) {
        if (a == null) {
            Pr.pr("null");
            return;
        }
        System.out.print("\n[ ");
        for (Object o:a) {
            System.out.print(o  + " ");
        }
        System.out.print("]\n");
    }
//    static void prArr(LinkedList a) {
//        if (a == null) {
//            Pr.pr("null");
//            return;
//        }
//        System.out.print("\n[ ");
//        for (Object o:a) {
//            System.out.print(o  + " ");
//        }
//        System.out.print("]\n");
//    }
}
