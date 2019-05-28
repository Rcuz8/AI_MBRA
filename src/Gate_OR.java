public class Gate_OR<T> extends Gate<T> {

    T c;

    public Gate_OR(T a, T b, T c) {
        super(a,b);
        this.c = c;
    }

    public Gate_OR(T c) {
        super(null,null );
        this.c = c;
    }

    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (exists(super.a) || exists(super.b)) {
            return c;
        }
        return null;
    }
}
