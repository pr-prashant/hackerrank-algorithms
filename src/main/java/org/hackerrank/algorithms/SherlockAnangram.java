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

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Prashant Patel
 */
class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String, Integer> ranges = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] charArray = s.substring(i, j).toCharArray();
                Arrays.sort(charArray);
                String sub = String.valueOf(charArray);
                ranges.put(sub, ranges.get(sub) != null ? ranges.get(sub) + 1 : 1);
            }
        }
        System.out.println(ranges);
        int annagrams = 0;
        for (int subFreq : ranges.values()) {
            annagrams += subFreq * (subFreq - 1) / 2;
        }
        return annagrams;
    }

}

public class SherlockAnangram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

