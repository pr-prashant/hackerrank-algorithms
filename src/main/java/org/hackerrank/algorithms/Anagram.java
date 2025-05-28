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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Prashant Patel
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.isEmpty() && t == null || t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Long> smap = s.chars().boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Map<Integer, Long> tmap = t.chars().boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : smap.entrySet()) {
            Integer k = entry.getKey();
            Long v = entry.getValue();
            if (tmap.containsKey(k)) {
                if (!Objects.equals(tmap.get(k), v)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
