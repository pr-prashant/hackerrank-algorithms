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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Prashant Patel
 */
public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] direction = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == x && current[1] == y) {
                return current[2];
            }
            for (int[] dir : direction) {
                int newX = current[0] + dir[0];
                int newY = current[1] + dir[1];
                if (!visited.contains(newX + "," + newY) && newX >= -200 && newX <= 200 && newY >= -200 && newY <= 302) {
                    visited.add(newX + "," + newY);
                    queue.add(new int[]{newX, newY, current[2] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        System.out.println(minimumKnightMoves.minKnightMoves(4, 4));
    }
}
