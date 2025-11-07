package org.hackerrank.algorithms;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Prashant Patel
 */
public class Abc {

    public static void main(String[] args) {
        int n = 7;

        int sum = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]}).limit(n)
                .map (x -> x[0])
                .collect(toList())
                .stream()
                .distinct()
                .filter(i -> i% 2 == 0)
                .mapToInt (i->i)
                .sorted()
                .sum() ;
        System.out.println(sum);
    }
}
