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
import java.io.InputStreamReader;

/**
 * @author Prashant Patel
 */

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new MissingNumbers().missingNumber(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
public class MissingNumbers {
    int missingNumber(int arr[]) {
        // code here
        int n = arr.length + 1;
        int newArr[] = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i]] = 1;
        }
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}