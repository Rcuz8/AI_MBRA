public class Gate_AND extends Gate {

    public Gate_AND(Boolean a, Boolean b) {
        super(a,b);
    }

    @Override
    public Boolean evaluate() {
        return super.a && super.b;
    }
}
