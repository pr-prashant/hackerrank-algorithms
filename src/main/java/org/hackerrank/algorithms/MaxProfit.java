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
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int i = prices.length - 1;
        int maxProfit = 0;
        while(i >= 0) {
            if (prices[i] >= max) {
                max = prices[i];
            } else if (max - prices[i] > maxProfit) {
                maxProfit = max - prices[i];
            }
            i--;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
