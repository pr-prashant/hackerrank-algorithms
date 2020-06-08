package org.hackerrank.algorithms;

import java.util.Scanner;

public class KindergardenAdventures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] extraTimes = new int[n];
        extraTimes[0] = 0;
        for (int i = 0; i < n; i++) {
            extraTimes[i] = scanner.nextInt();
        }
        int[] totalIncompleteDrawing = new int[n];
        int optimalNumber = 1;
        boolean flag = false;
        for (int j = 0; j < n; j++) {
            int reviewTime = 0;
            int incompleteDrawing = 0;
            for (int i = 0; i < n; i++) {
                int index = (j + i) >= n ? j+i-n : j+i;
                if(extraTimes[index] > 0 && (reviewTime - extraTimes[index]) < 0) {
                    incompleteDrawing++;
                }
                reviewTime++;
            }
            if(incompleteDrawing == 0){
                flag = true;
                optimalNumber = j;
                break;
            }
            totalIncompleteDrawing[j] = incompleteDrawing;
        }
        if(!flag){
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(totalIncompleteDrawing[i] < minimum){
                    minimum = totalIncompleteDrawing[i];
                    optimalNumber = i;
                }
            }
        }
        System.out.println(optimalNumber + 1);
    }
}