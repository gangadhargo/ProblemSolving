package Problems;

import java.util.ArrayList;
import java.util.List;

public class SPOJPrime {
    static List<Long> list = new ArrayList<>();
    private static long primeFactors(long n){
        long i = 2;
        long primeFactor = 0;
        int count = 0;

        while(i*i <= n){
            if(n % i == 0){
                if(isPrime(i)){
                    count++;
                    System.out.println(i);
                    if(count%100 == 1){
                        list.add(i);
                    }
                }
            }
            i++;
        }
        return primeFactor;
    }
    private static boolean isPrime(long num){
        System.out.println(num);
        boolean isPrime = true;
        long j = 2;
        while (j*j <= num){
            if(num % j == 0){
                isPrime = false;
            }
            j++;
        }
        return isPrime;
    }
    public static void main(String[] args) {
        primeFactors(169);
    }
}
