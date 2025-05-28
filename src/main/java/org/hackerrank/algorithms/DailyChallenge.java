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

/**
 * @author Prashant Patel
 */
public class DailyChallenge {

    public static int differenceOfSums(int n, int m) {
        int notDivSum = 0, divSum = 0;
        while (n > 0) {
            if (n % m != 0) {
                notDivSum += n;
            } else {
                divSum += n;
            }
            n--;
        }
        return notDivSum - divSum;
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
    }
}
