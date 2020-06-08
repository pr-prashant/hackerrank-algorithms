package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 12/31/2019
 **/
public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        ArrayRotation ar = new ArrayRotation();
        ar.rotate(arr, 2, 6);
        ar.primeFactor(315);
        ar.leastPrimeFactor(12);
    }

    private void rotate(int[] arr, int d, int n) {
        for(int i=0; i<arr.length; i++) {

        }
    }

    private int gcd(int a, int b) {
        if(b == 0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    private int lcm(int a, int b) {
        return (a*b) / gcd(a,b);
    }

    private void primeFactor(int n) {
        while(n % 2 == 0) {
            System.out.println("2 ");
            n = n/2;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2) {
            while(n % i == 0) {
                System.out.print(i + " ");
                n = n/i;
            }
        }
        if(n>2) {
            System.out.print(n + " ");
        }
    }

    public void leastPrimeFactor(int n)
    {
        // Create a vector to store least primes.
        // Initialize all entries as 0.
        int[] least_prime = new int[n+1];

        // We need to print 1 for 1.
        least_prime[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            // least_prime[i] == 0
            // means it i is prime
            if (least_prime[i] == 0)
            {
                // marking the prime number
                // as its own lpf
                least_prime[i] = i;

                // mark it as a divisor for all its
                // multiples if not already marked
                for (int j = 2*i; j <= n; j+=i)
                    if (least_prime[j] == 0)
                        least_prime[j] = i;
            }
        }

        // print least prime factor of
        // of numbers till n
        for (int i = 1; i <= n; i++)
            System.out.println("Least Prime factor of " +
                    + i + ": " + least_prime[i]);
    }
}
