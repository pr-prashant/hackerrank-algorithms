package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class GlobalMaximumResult {

    /*
     * Complete the 'findMaximum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER m
     */

    public static int findMaximum(List<Integer> a, int m) {
        // Write your code here
        List<List<Integer>> subSequence = new ArrayList<>();
        int[] temp = new int[m];
        findSubsequence(a, subSequence, a.size(), m, 0, temp, 0);
        subSequence.forEach(list-> {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
        int globalMaximum = 0;
        for(List<Integer> list: subSequence) {
            int currentMinimum = 1000000000;
            for(int i=0; i<list.size(); i++) {
                for(int j=i+1; j<list.size(); j++) {
                    int abs = Math.abs(list.get(i)-list.get(j));
                    if(abs < currentMinimum) {
                        currentMinimum = abs;
                    }
                }
            }
            if(currentMinimum > globalMaximum) {
                globalMaximum = currentMinimum;
            }
        }
        return globalMaximum;
    }

    public static void findSubsequence(List<Integer> arr, List<List<Integer>> result, int size, int m, int i, int[] tempData, int j) {
        if(i==m) {
            result.add(Arrays.stream(tempData).boxed().collect(toList()));
            return;
        }

        if(j>=size) {
            return;
        }

        tempData[i] = arr.get(j);
        findSubsequence(arr, result, arr.size(), m, i+1, tempData, j+1);

        findSubsequence(arr, result, arr.size(), m, i, tempData, j+1);
    }

}

public class GlobalMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int result = GlobalMaximumResult.findMaximum(a, m);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
