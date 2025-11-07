package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 3/8/2020
 **/
public class BinarySearchLCA {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return search(nums, start, end, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return search(nums, start, middle - 1, target);
        } else {
            return search(nums, middle + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
