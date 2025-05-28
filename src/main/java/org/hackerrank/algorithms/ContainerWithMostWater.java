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
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        int width = 0, ht = 0, area = 0;
        while (left < right) {
            width = right - left;
            ht = Math.min(height[left], height[right]);
            area = width * ht;
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
