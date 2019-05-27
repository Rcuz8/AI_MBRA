public abstract class Gate {

    public Boolean a;
    public Boolean b;
    public Str id;

    public Gate(Boolean a, Boolean b) {
        this.a = a;
        this.b = b;
        id = Str.randomized(10);
    }

    public Gate() { this.a = false;this.b = false; this.id = Str.randomized(10); }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            Pr.pr("WARNING: Comparing to null ??");
            return false;
        }
        return ((Gate) obj).id.stringVal().equals(this.id.stringVal());
    }

    public abstract Boolean evaluate();

}
