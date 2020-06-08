package org.hackerrank.algorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 *
 * Useful tutorial
 * https://www.youtube.com/watch?v=zPnN046OM34
 *
 * @author Prashant Patel (312455)
 * Date: 8/3/2019
 **/
public class MagicSquare {

    // All possible magic squares for 3 * 3
    static int[][][] magicArrays = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
    };
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        TreeSet<Integer> totalSet = new TreeSet<>();
        for (int[][] magicArr: magicArrays) {
            int total = 0;
            for(int i=0; i<magicArr.length; i++) {
                for (int j=0; j<magicArr[i].length; j++) {
                    if(magicArr[i][j] != s[i][j]) {
                        total += Math.abs(magicArr[i][j]-s[i][j]);
                    }
                }
            }
            totalSet.add(total);
        }
        return totalSet.first();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

