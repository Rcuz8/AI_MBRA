public class Gate_AND extends Gate {

    public Gate_AND(Boolean a, Boolean b) {
        super(a,b);
    }

    public Gate_AND() {
        super();
    }

    @Override
    public Boolean evaluate() {
        return super.a && super.b;
    }
}
