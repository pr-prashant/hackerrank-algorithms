package org.hackerrank.algorithms;

/**
 * @author Prashant Patel
 * <a href="https://www.geeksforgeeks.org/the-celebrity-problem/">Celebrity Problem</a>
 */
public class CelebrityProblem {

    public static int celebrity(int[][] mat) {
        int i = 0, j = mat.length - 1;
        while (i < j) {
            if (mat[j][i] == 1) {
                j--;
            } else {
                i++;
            }
        }
        int potentialCelb = i;
        for (int k = 0; k < mat.length; k++) {
            if (k == i) continue;
            if (mat[i][k] != 0 || mat[k][i] == 0) {
                return -1;
            }
        }
        return potentialCelb;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(celebrity(mat));
    }
}
