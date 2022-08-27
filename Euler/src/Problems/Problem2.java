package Problems;

public class Problem2 {
     static int sum = 2;
    private static int fibonacci(int n){
       int a = 1;
       int b = 2;
        int c = 0;
        while (c <= n) {
            c = a + b;
            if (c % 2 == 0) {
                sum += c;
            }
            a = b;
            b = c;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(4000000));
    }
}
