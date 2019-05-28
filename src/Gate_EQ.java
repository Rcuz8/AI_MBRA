public class Gate_EQ<T> extends Gate<T> {

    T c;

    // c is the keep-value if it exists
    public Gate_EQ(T a, T b, T c) {
        super(a,b);
        this.c = c;
    }

    public Gate_EQ(T c) {
        super(null,null);
        this.c = c;
    }

    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (super.a == null && super.b == null) return c;
        if (super.a == null || super.b == null) return null;
        if (super.a.equals(super.b)) return c;
        return null;
    }


}
