public class Gate_AND<T> extends Gate<T> {

    T c;

    // c is the keep-value if it exists
    public Gate_AND(T a, T b, T c) {
        super(a,b);
        this.c = c;
    }

    public Gate_AND(T c) {
        super(null,null);
        this.c = c;
    }

    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (exists(super.a) && exists(super.b)) {
            return c;
        }
        return null;
    }

}
