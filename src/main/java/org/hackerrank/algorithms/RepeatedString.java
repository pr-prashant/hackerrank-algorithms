package org.hackerrank.algorithms;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Prashant Patel (312455)
 * Date: 2/29/2020
 **/

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long totalCount = 0;
        if(s.length() > 1) {
            long count = s.chars().filter(c->c=='a').count();
            long mod = Math.floorMod(n, (long)(s.length()));
            long remainingS = s.subSequence(0,(int)mod).chars().filter(c->c=='a').count();
            long l = Math.floorDiv(n, (long)s.length());
            totalCount = count * l + remainingS;
        } else if(s.contains("a")) {
            totalCount = n;
        }
        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
