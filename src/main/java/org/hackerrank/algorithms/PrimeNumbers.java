package org.hackerrank.algorithms;

/**
 * @author Prashant Patel
 */
public class PrimeNumbers {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n ==3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(n); i++) {
            if (n % i == 0 || (n % (i + 2) == 0)) {
                return false;
            }
        }
        return true;
    }

    public static int primeGenerator(int n) {
        int[] primeCount = new int[n];
        primeCount[0] = 0;
        primeCount[1] = 0;
        primeCount[2] = 1;
        primeCount[3] = 2;
        primeCount[4] = 2;
        for (int i = 5; i < n; i++) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                primeCount[i] = primeCount[i-1] + 1;
            } else {
                primeCount[i] = primeCount[i-1];
            }
        }
        return primeCount[n-1];
        /*int count = 2;
        for (int i = 5; i < n; i = i+2) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                count++;
                primeCount[i] = primeCount[i-1] + 1;
            } else {
                primeCount[i] = primeCount[i-1];
            }
        }
        return count;*/
    }

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        int i = primeGenerator(1000000);
        long totalTime = System.currentTimeMillis() - timeStart;
        System.out.println("Total Primes : " + i + " Time Taken : " + totalTime);
    }
}
