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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Prashant Patel
 */
public class FruitBasket {

    public int totalFruit(int[] fruits) {
        int max = 0;
        int left = 0, right = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int max_fruit;
        while (right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while (basket.size() > 2) {
                if (basket.get(fruits[left]) != null) {
                    int value = basket.get(fruits[left]) - 1;
                    if (value > 0)
                        basket.put(fruits[left], value);
                    else
                        basket.remove(fruits[left]);
                }
                left++;
            }
            max_fruit = right - left + 1;
            if (max_fruit > max) {
                max = max_fruit;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        FruitBasket fruitBasket = new FruitBasket();
//        int[] fruits = {0,1,6,6,4,4,6};
//        int[] fruits = {0,1,6,6,4,4,6};
//        int[] fruits = {0,1,6,6,4,4,6};
//        int[] fruits = {0,1,6,6,4,4,6};
        int[] fruits = {1,0,2,3,4};
        System.out.println(fruitBasket.totalFruit(fruits));
    }
}
