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

import java.util.ArrayList;
import java.util.List;

public class PerformanceComparisonMain {
    public static void main(String[] args) {

        long currentTime = System.currentTimeMillis();
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            data.add(i);
        }

        long sum = data.parallelStream()
                .map(i -> (int) Math.sqrt(i))
                .map(number -> performComputation(number))
                .reduce(0, Integer::sum);

        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to complete:" + (endTime - currentTime) / (1000) + " minutes");

    }

    public static int performComputation(int number) {
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            int div = (number / i);
            sum += div;

        }
        return sum;
    }
}