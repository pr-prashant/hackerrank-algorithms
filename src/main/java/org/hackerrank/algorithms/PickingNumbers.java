package org.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PickingNumbers {

    static int pickingNumbers(int[] a) {
        // Complete this function

        int[] countArray = new int[100];

        for (int i = 0; i < a.length; i++) {
            countArray[a[i]] +=1;
        }
//        int[] index= {0};
//        Arrays.stream(countArray).forEach(i->  System.out.println(index[0]++ + "-" + i));
        Arrays.sort(a);
        int maxCount = 0;
        for (int i = 0; i < a.length-1; i++) {
            if(Math.abs(a[i]-a[i+1])<=1){
                int count = a[i]!=a[i+1] ? countArray[a[i]] + countArray[a[i+1]] : countArray[a[i]];
                if(count>maxCount){
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
