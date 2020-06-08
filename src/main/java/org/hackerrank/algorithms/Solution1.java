package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 3/11/2020
 **/
public class Solution1 {
    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] >= X) {
                r = m;
            } else {
                l = m+1;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.solution(new int[]{1,2,5,9,9},9));
    }
}
