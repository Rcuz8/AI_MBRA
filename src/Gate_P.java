public class Gate_P<T> extends Gate<T> {

    double p;
    T c;

    public Gate_P(T a, T c, double p) {
        super(a,null);
        this.p = p;
        this.c = c;
    }

    public Gate_P(T c) {
        super(null,null);
        this.c = c;
    }

    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (_Util.rand_fromP(p)) {
            if (exists(super.a))
                return super.a;
            return null;
        }
        if (exists(super.a))
            return null;
        return this.c;
    }

}