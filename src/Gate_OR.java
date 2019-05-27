public class Gate_OR extends Gate {

    public Gate_OR(Boolean a, Boolean b) {
        super(a,b);
    }

    @Override
    public Boolean evaluate() {
        return super.a || super.b;
    }
}
