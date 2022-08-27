package Problems;

public class Problem3 {

//    The prime factors of 13195 are 5, 7, 13 and 29.
//
//    What is the largest prime factor of the number 600851475143 ?



    private static long primeFactors(long n){
        long i = 2;
        long primeFactor = 0;
        while(i*i <= n){
            if(n % i == 0){
                if(isPrime(i)){
                    primeFactor = Math.max(i, primeFactor);
                }
            }
            i++;
        }
        return primeFactor;
    }
    private static boolean isPrime(long num){
        boolean isPrime = true;
        long j = 2;
        while (j*j <= num){
            if(num % j == 0){
                isPrime = false;
                break;
            }
            j++;
        }
        return isPrime;
    }
    public static void main(String[] args) {
        System.out.println(primeFactors(600851475143l));
    }
}
