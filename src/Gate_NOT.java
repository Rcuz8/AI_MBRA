public class Gate_NOT extends Gate {

    public Gate_NOT(Boolean a) {
        super(a,null);
    }

    @Override
    public Boolean evaluate() {
        return !super.a;
    }
}
