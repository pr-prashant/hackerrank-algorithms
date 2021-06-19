package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Prashant Patel
 * <p>
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
class MinimumBribes {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    /*
     *
        From here on out, we don't care if P has moved
        forwards, it is better to count how many times
        P has RECEIVED a bribe, by looking at who is
        ahead of P.  P's original position is the value
        of P.
        Anyone who bribed P cannot get to higher than
        one position in front if P's original position,
        so we need to look from one position in front
        of P's original position to one in front of P's
        current position, and see how many of those
        positions in Q contain a number large than P.
        In other words we will look from P-1 to i-1,
        which in Python is range(P-1,i-1+1), or simply
        range(P-1,i).  To make sure we don't try an
        index less than zero, replace P-1 with
        max(P-1,0)
     *
     * @param q
     */
    public static void minimumBribes(List<Integer> q) {
        // Write your code here

        int bribes = 0;
        for (int i = 0; i < q.size(); i++) {
            if ((q.get(i) - (i + 1)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(q.get(i) - 2, 0); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }
}

public class NewYearChaos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                MinimumBribes.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
