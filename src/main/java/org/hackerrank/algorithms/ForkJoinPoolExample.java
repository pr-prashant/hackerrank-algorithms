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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkJoinPoolExample {

    // RecursiveTask to sum an array of integers
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 1000; // Threshold for splitting tasks
        private final int[] numbers;
        private final int start;
        private final int end;

        // Constructor
        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // If the task is small enough, compute directly
            if ((end - start) <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += numbers[i];
                }
                return sum;
            } else {
                // Otherwise, split the task into two subtasks
                int middle = (start + end) / 2;
                SumTask leftTask = new SumTask(numbers, start, middle);
                SumTask rightTask = new SumTask(numbers, middle, end);

                // Fork the subtasks (execute them asynchronously)
                leftTask.fork();  // Asynchronously execute the left task
                long rightResult = rightTask.compute(); // Compute the right task directly
                long leftResult = leftTask.join(); // Wait for the left task to complete and get the result

                // Combine the results
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Create an array of 10 million random integers
        /*int[] numbers = new int[10_000_000_00];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }

        // Create a ForkJoinPool instance
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // Create a SumTask to sum the array
        SumTask task = new SumTask(numbers, 0, numbers.length);

        // Start the task in the ForkJoinPool and get the result
        long startTime = System.currentTimeMillis();
        long result = forkJoinPool.invoke(task); // Fork and join the task

        long endTime = System.currentTimeMillis();
        System.out.println("Sum: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");*/

        String s = "lasdfjlkoiasdjlkansdlfkhaoie,mansdkjfhakshfdkasfklhksphuikljkhiuakdsjnfaksdf";
        Map<String, Long> output = Arrays.stream(s.split("")).collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
                .filter(i -> i.getValue() > 1).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println(output);

        List<Integer> salaries = List.of(234, 23, 444, 22, 999, 1010);
        salaries.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(3);
    }
}

