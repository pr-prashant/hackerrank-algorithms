package org.hackerrank.algorithms;

import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////
// https://www.hackerrank.com/challenges/sparse-arrays
///////////////////////////////////////////////////////////////////////////

/*
* https://www.hackerrank.com/challenges/sparse-arrays
*
* */
public class ArrayManipulation2 {

    /*
     * Complete the arrayManipulation function below.
     */
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n+1];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1], k = queries[i][2];
            array[a] += k;
            if(b+1 <= n) {
                array[b+1] -= k;
            }
        }
        long x = 0, max = Integer.MIN_VALUE ;
        for (int i = 1; i <= n ; i++) {
            x+=array[i];
            if(max<x) max = x;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] queries = new int[m][3];

        for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

    }

}
