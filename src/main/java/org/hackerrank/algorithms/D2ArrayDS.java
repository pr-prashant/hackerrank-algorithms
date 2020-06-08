package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 3/3/2020
 **/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class D2ArrayDS {

    // Complete the hourglassSum function below.
    private static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i=1; i<arr.length-1;i++) {
            for (int j=1;j<arr[i].length-1;j++) {
                int hourGlassSum = findHourGlassSum(arr, i, j);
                if(hourGlassSum>max) {
                   max = hourGlassSum;
                }
            }
        }
        return max;
    }

    private static int findHourGlassSum(int[][] arr, int r, int c) {
        return arr[r][c] + arr[r-1][c-1] + arr[r-1][c] + arr[r-1][c+1] + arr[r+1][c-1] + arr[r+1][c] + arr[r+1][c+1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

