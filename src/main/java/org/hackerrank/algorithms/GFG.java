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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            SolutionGFG obj = new SolutionGFG();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends

class SolutionGFG {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int leftInd = -1, rightInd = -1;
        ArrayList<Integer> arrayList = new ArrayList<>();

/*        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            if (sum == s) {
                leftInd = i + 1;
                rightInd = leftInd;
                arrayList.add(leftInd);
                arrayList.add(rightInd);
                return arrayList;
            }
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                if (sum == s) {
                    leftInd = i + 1;
                    rightInd = j + 1;
                    arrayList.add(leftInd);
                    arrayList.add(rightInd);
                    return arrayList;
                }
            }
        }
        arrayList.add(-1);*/
//        return arrayList;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < n) {
            sum += arr[right];
            while (sum > s && left < right) {
                sum -= arr[left];
                left++;
            }
            if (sum == s) {
                break;
            }
            right++;
        }
        if (sum == s) {
            arrayList.add(left + 1);
            arrayList.add(right + 1);
        } else {
            arrayList.add(-1);
        }
        return arrayList;
    }
}

