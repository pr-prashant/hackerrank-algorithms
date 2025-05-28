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

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Prashant Patel
 */
public class Example {

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(0, 1, 2, 4, 3, 5, 6, 2, 4, 0, 1, 2, 4, 3, 5, 6, 2, 4, 0, 1, 2, 4, 3, 5, 6, 2, 4, 0, 1, 2, 4, 3, 5, 6, 2, 4, 5, 6);

        TreeMap<Integer, Long> collect = array.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        collect.forEach((k, v) -> {
            while(v > -1) {
                System.out.print(k + " ");
                v--;
            }
        });
    }
}
