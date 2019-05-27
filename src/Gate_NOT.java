public class Gate_NOT extends Gate {

    public Gate_NOT(Boolean a) {
        super(a,false);
    }

    public Gate_NOT() {
        super();
    }

    @Override
    public Boolean evaluate() {
        return !super.a;
    }
}
