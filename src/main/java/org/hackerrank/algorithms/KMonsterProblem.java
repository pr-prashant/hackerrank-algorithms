package org.hackerrank.algorithms;

import java.util.Arrays;

/**
 * @author Prashant Patel
 */
public class KMonsterProblem {

    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] timeToReach = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            timeToReach[i] = ((double) dist[i] /speed[i]);
        }
        Arrays.sort(timeToReach);
        int maxMon = 0;
        for (int i = 0; i < dist.length; i++) {
            if (timeToReach[i] <= i) {
                break;
            }
            maxMon++;
        }
        return maxMon;
    }

    public static void main(String[] args) {
        KMonsterProblem k = new KMonsterProblem();
        System.out.println(k.eliminateMaximum(new int[]{1,1,2,3}, new int[]{1,1,1,1}));
        System.out.println(k.eliminateMaximum(new int[]{3,5,7,4,5}, new int[]{2,3,6,3,2}));
    }
}
