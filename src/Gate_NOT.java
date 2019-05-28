/*
    NULL -> NON-NULL (EMPTY)
    NON-NULL -> NULL
 */
public class Gate_NOT<T> extends Gate<T> {

    T c; // could make static??

    // c is the keep-value if it doesn't exist
    public Gate_NOT(T t, T c) {
        super(t,null);
        this.c = c;
    }

    public Gate_NOT(T c) {
        super(null,null);
        this.c = c;
    }

    boolean exists(Tuple<T,T> t) { return (t != null); }
    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (!exists(super.a)) {
            return c;
        }
        return null;
    }
}