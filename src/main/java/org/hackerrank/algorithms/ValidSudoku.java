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
// https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[10][10];
        int[][] cols = new int[10][10];
        int[][] subMats = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                int val = Character.getNumericValue(value);
                if (rows[i][val] == 1) {
                    return false;
                }
                rows[i][val] = 1;

                if (cols[j][val] == 1) {
                    return false;
                }
                cols[j][val] = 1;

                int subIndex = (i / 3) * 3 + (j / 3);
                if (subMats[subIndex][val] == 1) {
                    return false;
                }
                subMats[subIndex][val] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][] {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(sudoku));
    }
    
}
