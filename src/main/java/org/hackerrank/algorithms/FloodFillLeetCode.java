package org.hackerrank.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Prashant Patel
 */
public class FloodFillLeetCode {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalPixel = image[sr][sc];
        if (image[sr][sc] == color) {
            return image;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc});
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] el = queue.poll();
                image[el[0]][el[1]] = color;
                for (int[] direction : directions) {
                    int row = el[0] + direction[0];
                    int column = el[1] + direction[1];
                    if (row >= 0 && row < image.length && column >= 0 && column < image[0].length && image[row][column] == originalPixel) {
                        image[el[0]][el[1]] = color;
                        queue.add(new int[]{row, column});
                    }
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFillLeetCode fl = new FloodFillLeetCode();
        int[][] result = fl.floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        }, 1, 1, 2);
        System.out.println(result);
    }
}
