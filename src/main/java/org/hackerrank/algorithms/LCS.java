/*
 * *********************************************************************
 * Copyright (C) Calibo LLC 2021. All rights reserved.
 *
 * This software is confidential and proprietary information
 * of Calibo LLC. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Calibo LLC.
 * ********************************************************************
 */

package org.hackerrank.algorithms;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Prashant Patel
 */
public class LCS {

    public static void main(String[] args) {
        String s1 = "AAFGEDEDS", s2 = "AAEBTSDD";
        int s1l = s1.length(), s2l = s2.length();
        int[][] mn = new int[s1l + 1][s2l + 1];
        for (int[] arr : mn) {
            Arrays.fill(arr, -1);
        }
        StringBuilder lcsStr = new StringBuilder();
        int lcs = lcs(s1, s2, s1l, s2l, mn);
        System.out.println("LCS : " + lcs);

        int i = s1l, j = s2l;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsStr.append(s1.charAt(i - 1));
                i--; j--;
            } else {
                if (mn[i-1][j] > mn[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println("LCS String : " + StringUtils.reverse(lcsStr.toString()));
    }

    private static int lcs(String s1, String s2, int m, int n, int[][] mn) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (mn[m][n] != -1) {
            return mn[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            mn[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, mn);
        } else {
            mn[m][n] = Math.max(lcs(s1, s2, m, n-1, mn), lcs(s1, s2, m-1, n, mn));
        }
        return mn[m][n];
    }
}
