package org.hackerrank.algorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard
 *
 * @author Prashant Patel (312455)
 * Date: 3/5/2020
 **/
public class ClimbingLeaderboard {

    /*
     * Complete the climbingLeaderboard function below.
     */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        /*
         * Write your code here.
         */
        List<Integer> ranks = new ArrayList<>();
        int i=0;
        while(i<scores.length-1) {
            ranks.add(scores[i]);
            int j=i+1;
            while(j<scores.length && scores[i]==scores[j]) {
                j+=1;
            }
            i=j;
        }
        ranks.add(scores[scores.length-1]);
        int[] aliceRank = new int[alice.length];
        for (int j=0; j< alice.length; j++) {
            int index = Collections.binarySearch(ranks, alice[j],Comparator.reverseOrder());
            aliceRank[j] = index > 0 ? index + 1 : index == 0 ? 1 : Math.abs(index);
        }
        return aliceRank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = Integer.parseInt(scanner.nextLine().trim());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
            scores[scoresItr] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine().trim());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
            alice[aliceItr] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
