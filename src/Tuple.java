public class Tuple<T> {
    public T a;
    public T b;
    public Tuple(T a, T b) { this.a = a; this.b = b;}

    public void print() { System.out.println("Tuple { a: " + a + "  b: " + b + " }\n"); }
}
