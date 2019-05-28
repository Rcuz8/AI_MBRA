public class Gate_input<T> extends Gate<T> {

    public Gate_input(T a) {
        super(a,null);
    }

    public Gate_input() {
        super(null,null);
    }

    boolean exists(T t) { return (t != null); }

    @Override
    public T evaluate() {
        if (exists(super.a)) {
            return super.a;
        }
        return null;
    }

}