package org.hackerrank.algorithms;

import java.util.Scanner;

public class LeftRotation {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int d = in.nextInt();

        int[] a = new int[n];
        for (int aItr = 0; aItr < n; aItr++) {
            a[aItr] = in.nextInt();
        }

        for (int i = 0, j = d; i < n; i++) {
            int index = (j + i) >= n ? j+i-n : j+i;
            System.out.print(a[index] + " ");
        }

    }


}
