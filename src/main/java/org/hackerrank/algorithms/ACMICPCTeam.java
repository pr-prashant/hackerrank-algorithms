package org.hackerrank.algorithms;

/**
 * @author Prashant Patel (312455)
 * Date: 2/29/2020
 **/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team/problem
 */
public class ACMICPCTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        TreeMap<Integer, Integer> result = new TreeMap<>();
        for(int i=0; i<topic.length; i++) {
            BigInteger iStr = new BigInteger(topic[i],2);
            for(int j=i; j<topic.length; j++) {
                BigInteger jStr = new BigInteger(topic[j],2);
                BigInteger s = iStr.or(jStr);
                if(result.containsKey(s.bitCount())){
                    result.put(s.bitCount(),result.get(s.bitCount())+1);
                } else {
                    result.put(s.bitCount(), 1);
                }
            }
        };
        Map.Entry<Integer, Integer> entry = result.descendingMap().firstEntry();
        int[] arr = new int[2];
        arr[0] = entry.getKey();
        arr[1] = entry.getValue();
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

