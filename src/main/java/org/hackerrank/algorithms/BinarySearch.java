package org.hackerrank.algorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Prashant Patel (312455)
 * Date: 3/8/2020
 **/
public class BinarySearch {

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
            int index = binarySearch(ranks, alice[j], Comparator.reverseOrder());
            aliceRank[j] = index > 0 ? index + 1 : index == 0 ? 1 : Math.abs(index);
        }
        return aliceRank;
    }

    public static <T> int binarySearch(List<T> list, T number, Comparator<T> comparator) {
        return binarySearch(list,0,list.size()-1,number, comparator);
    }

    public static <T> int binarySearch(List<T> list, int start, int end, T number, Comparator<T> comparator) {
        if(start<=end) {
            int middle=(start+end)/2;
            int c = comparator.compare(list.get(middle), number);
            if(c == 0) {
                return middle;
            } else if(c < 0) {
                return binarySearch(list, middle+1,end,number, comparator);
            } else {
                return binarySearch(list, start, middle-1, number, comparator);
            }
        }
        return -(start+1);
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
