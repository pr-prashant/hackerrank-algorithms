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

import java.util.*;

/**
 * @author Prashant Patel
 */
public class TwoNumber {
    public int[] twoSum(int[] nums, int target) {
        if (nums != null && nums.length > 1) {
            Map<Integer, Integer> visited = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int validValue = target - nums[i];
                if (visited.containsKey(validValue)) {
                    return new int[]{visited.get(validValue), i};
                }
                visited.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
