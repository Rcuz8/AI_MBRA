public class Tuple<T,  V> {
    public T a;
    public V b;
    public Tuple(T a, V b) { this.a = a; this.b = b;}

    public void print() { System.out.println("Tuple { a: " + a + "  b: " + b + " }\n"); }
}
