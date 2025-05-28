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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Prashant Patel
 */
public class MergeInterval {

    public List<int[]> employeeFreeTime(int[][] schedules) {
        List<int[]> list = Arrays.stream(schedules).sorted(Comparator.comparing(schedule -> schedule[0])).toList();
        list.forEach(i -> System.out.println(Arrays.toString(i)));
        List<int[]> mergedList = new ArrayList<>();
        int i = 0; int j = 1;
        while (i < list.size()) {
            int[] merged = new int[2];
            merged[0] = list.get(i)[0];
            merged[1] = list.get(i)[1];
            while (j < list.size() && merged[1] >= list.get(j)[0]) {
                merged[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                j++;
            }
            i = j;
            j++;
            mergedList.add(merged);
        }
        mergedList.forEach(k -> System.out.println(Arrays.toString(k)));
        List<int[]> freeTimeList = new ArrayList<>();
        if (mergedList.size() > 1) {
            i = 0; j = 1;
            while (j < mergedList.size() ) {
                if (mergedList.get(i)[1] != mergedList.get(j)[0]) {
                    int[] freeTime = new int[2];
                    freeTime[0] = mergedList.get(i)[1];
                    freeTime[1] = mergedList.get(j)[0];
                    freeTimeList.add(freeTime);
                }
                i++;
                j++;
            }
            return freeTimeList;
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] schedules = {
                {2, 4},
                {7, 10},
                {1, 5},
                {6, 9}
        };
        int[][] schedules1 = {
                {1, 7},
                {11, 12},
                {2, 6},
                {15, 19},
                {3, 5},
                {8, 10},
                {4, 8},
                {19, 20}
        };
        List<int[]> result = mergeInterval.employeeFreeTime(schedules1);
        result.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
