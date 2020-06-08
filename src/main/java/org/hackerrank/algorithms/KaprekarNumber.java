package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 2/29/2020
 **/

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class KaprekarNumber {

    private static boolean kaprekarNumberFound = false;
    // Complete the kaprekarNumbers function below.
    private static void kaprekarNumbers(int p, int q) {
        IntStream.range(p,q+1).filter(KaprekarNumber::isKaprekarNumber).forEach(m -> System.out.print(m + " "));
        if (!kaprekarNumberFound) {
            System.out.println("INVALID RANGE");
        }
    }

    /**
     * get the formula from wikipedia for kaprekar number
     * @param n
     * @return
     */
    private static boolean isKaprekarNumber(int n) {
        int p = String.valueOf(n).length();
        long square = (long) Math.pow(n,2), power = (long) Math.pow(10, p) ;
        long beta = Math.floorMod(square, power);
        long alpha = (square - beta) / power;
        if((alpha + beta) == n && !kaprekarNumberFound) {
            kaprekarNumberFound = true;
        }
        return (alpha + beta) == n;
    }


    static boolean isKaprekarNumberImpl2(int n) {
        int p = String.valueOf(n).length();
        String square = String.valueOf(Math.pow(n,2));
        String temp = square.substring(0, square.length()-p);
        if(!temp.trim().equals("")) {
            int alpha = Integer.parseInt(temp);
            int beta = Integer.parseInt(square.substring(square.length()-p));
            if((alpha + beta) == n && !kaprekarNumberFound) {
                kaprekarNumberFound = true;
            }
            return (alpha + beta) == n;
        }
        return n == 1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
