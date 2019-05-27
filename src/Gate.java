public abstract class Gate {

    public Boolean a;
    public Boolean b;
    public Str id;

    public Gate(Boolean a, Boolean b) {
        this.a = a;
        this.b = b;
        id = Str.randomized(10);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Gate) obj).id.stringVal().equals(this.id.stringVal());
    }

    public abstract Boolean evaluate();

}
