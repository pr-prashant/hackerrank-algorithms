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
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Prashant Patel
 */
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public void moveZeroes(int[] nums) {
        /*int j = 0, i = 0;
        while (j < nums.length) {
            if (nums[i] != 0) {
                i++;
                j++;
            } else {
                j = i+1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j++;
                }
            }
        } */
        int nextNonZero = 0;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[i];
                nums[i] = nums[nextNonZero];
                nums[nextNonZero] = tmp;
                nextNonZero++;
            }
        }
    }

    /*public void sortColors(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int zeroIndex = map.getOrDefault(0, 0L).intValue();
        if (zeroIndex != 0) {
            Arrays.fill(nums, 0, zeroIndex, 0);
        }
        int oneIndex = zeroIndex + map.getOrDefault(1, 0L).intValue();
        if (oneIndex != zeroIndex) {
            Arrays.fill(nums, zeroIndex, oneIndex, 1);
        }
        int twoIndex = oneIndex + map.getOrDefault(2, 0L).intValue();
        if (twoIndex != oneIndex) {
            Arrays.fill(nums, oneIndex, twoIndex, 2);
        }
    }*/

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length -1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                i++;
            }
        }
    }

    public int trapRainWater(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftMax = heights[left], rightMax = heights[right];
        int count = 0;
        while (left + 1 <= right) {
            if (leftMax > rightMax) {
                left++;
                if (heights[left] > leftMax) {
                    leftMax = heights[left];
                } else {
                    count += heights[leftMax] - heights[left];
                }
            } else {
                right--;
                if (heights[right] > rightMax) {
                    rightMax = heights[right];
                } else {
                    count += heights[rightMax] - heights[right];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
//        int[] nums = {11,4,9,6,15,18};
//        System.out.println(validTriangleNumber.triangleNumber(nums));
//        int[] nums = {2,0,1,0,4,0,3,0,5};
        int[] nums = {2, 2};
//        int[] nums = {0,1,0,3,12};
//        validTriangleNumber.moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
        validTriangleNumber.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
