import java.util.Random;

public class Str {

    private String self;

    public Str(String s) {
        self = s;
    }

    public void setStringVal(String s) { self = s; }

    public String stringVal() { return self; }

    public void a(char c) { self = self + c; }
    public void a(String c) { self = self + c; }

    static Str randomized(int length) {
        Str s = new Str("");
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        while (length > 0) {
            s.a(AlphaNumericString.charAt(new Random().nextInt(AlphaNumericString.length())));
            length--;
        }
        return s;
    }

    boolean isPalendrome()  {
        String s = self;
        if (s.length() % 2 == 1) {
            int mid = s.length()/2;
            for (int i = 0; i < s.length()/2; i++) {
                int a = mid-i;
                int b = mid+i;
                char c1 = s.charAt(a);
                char c2 = s.charAt(b);
                if (s.charAt(a) != s.charAt(b))
                    return false;
            }
            return true;
        } else {
            int mid = s.length() / 2 - 1;
            for (int i = 0; i < s.length() / 2; i++) {
                int a = mid - i;
                int b = mid + i + 1;
                char c1 = s.charAt(a);
                char c2 = s.charAt(b);
                if (s.charAt(a) != s.charAt(b))
                    return false;
            }
            return true;
        }
    }

    long int_str_product() {

        long product = 1;
        for (char c: self.toCharArray()) {
            long i = Integer.parseInt(c+"");
            product*=i;
        }
        return product;
    }

    int int_str_sum() {
        int sum = 0;
        for (char c: self.toCharArray()) {
            int i = Integer.parseInt(c+"");
            sum+=i;
        }
        return sum;
    }

}
