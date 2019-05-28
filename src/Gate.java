public abstract class Gate<T> {

    public T a;
    public T b;
    public Str id;

    public Gate(T a, T b) {
        this.a = a;
        this.b = b;
        id = Str.randomized(10);
    }

//    public Gate() { this.a = false;this.b = false; this.id = Str.randomized(10); }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            Pr.pr("WARNING: Comparing to null ??");
            return false;
        }
        return ((Gate) obj).id.stringVal().equals(this.id.stringVal());
    }

    public abstract T evaluate();

}
