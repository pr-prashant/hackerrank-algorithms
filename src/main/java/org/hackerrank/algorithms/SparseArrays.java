package org.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SparseArrays {


    /*
     * Complete the findSuffix function below.
     */
    static int findSuffix(String[] collections, String queryString) {
        return (int)Arrays.stream(collections).filter(s->s.equals(queryString)).count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder("");

        int n = Integer.parseInt(scanner.nextLine().trim());

        String[] strings = new String[n];

        for (int stringsItr = 0; stringsItr < n; stringsItr++) {
            String stringsItem = scanner.nextLine();
            strings[stringsItr] = stringsItem;
        }

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String queryString = scanner.nextLine();

            int res = findSuffix(strings, queryString);

            output.append(res+"\n");
        }
        System.out.println(output);
    }
}
