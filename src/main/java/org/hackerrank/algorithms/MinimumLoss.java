package org.hackerrank.algorithms;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *  https://www.hackerrank.com/challenges/minimum-loss/problem
 *
 *  @author Prashant Patel
 *
 *
 */

public class MinimumLoss {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
        }
        long result = minimumLoss(price);
        System.out.println(result);
        in.close();
    }

    private static long minimumLoss(long[] price) {
        long minimumLoss = Long.MAX_VALUE;
        /*for (int i = 0; i < price.length-1; i++) {
            for (int j = i+1; j < price.length; j++) {
                if(price[i] > price[j] && (price[i] - price[j]) < minimumLoss) {
                    minimumLoss = (int)(price[i] - price[j]);
                    System.out.println("Minimum Loss : " + minimumLoss);
                }
            }
        }*/
        //Stores the indexes values of sorted array.
        int[] indexes = IntStream.range(0, price.length).boxed().sorted((i, j)->(Long.compare(price[i], price[j]))).mapToInt(e->e).toArray();
        for (int i = 0; i < indexes.length-1; i++) {
            // if the index of the adjacent index is lower then only calculate the difference
            if(indexes[i] > indexes[i+1]) {
                long tempMin = (price[indexes[i+1]] - price[indexes[i]]);
                if(tempMin > 0 && tempMin < minimumLoss) {
                    minimumLoss = tempMin;
//                    System.out.println("Minimum Loss : " + minimumLoss + " || " + price[indexes[i+1]] + "(" +indexes[i+1] + ")" + " and " + price[indexes[i]]+ "("+ indexes[i]+")");
                }
            }
        }
        return minimumLoss;
    }
}