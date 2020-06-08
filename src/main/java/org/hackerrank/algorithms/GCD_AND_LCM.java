package org.hackerrank.algorithms;

public class GCD_AND_LCM {
    public static void main(String[] args) {
        int no1=130;
        int no2=225;
        System.out.println(calculateGCD(no1,no2));
        System.out.println(calculateLCM(no1, no2));
    }

    private static int calculateLCM(int no1, int no2) {
        return (no1* no2)/calculateGCD(no1, no2);
    }

    private static int calculateGCD(int no1,int no2) {
        if (no1 == 0) {
            return no2;
        } else {
            return calculateGCD(no2%no1, no1);
        }

    }
}
