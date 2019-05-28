import java.util.Random;

public class _Util {

    static double rounded(double f, int dig) {
        return Math.round(f * Math.pow(10,dig)) / Math.pow(10,dig);
    }

    static boolean rand_fromP(double p_true) {
        double x = rounded(Math.random(),3);
//        Pr.pr(x + (x < p_true ? " < " : " > ") +p_true);
        return (x < p_true);
    }

}
