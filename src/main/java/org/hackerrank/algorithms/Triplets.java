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

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Prashant Patel
 */
public class Triplets {

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> rightElem = new LinkedHashMap<>();
        Map<Long, Long> leftElem = new LinkedHashMap<>();

        arr.forEach(e -> {
            rightElem.put(e, rightElem.getOrDefault(e, 0L) + 1);
        });
        long triplets = 0;
        if (r == 1) {
            for (Long v : rightElem.values()) {
                triplets += v * (v - 1) * (v - 2) / 6;
            }
            return triplets;
        }
        for (Long el : arr) {
            rightElem.put(el, rightElem.get(el) - 1);
            triplets += rightElem.getOrDefault(el * r, 0L) * leftElem.getOrDefault(el / r, 0L);
            leftElem.put(el, leftElem.getOrDefault(el, 0L) + 1);
        }
        return triplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
