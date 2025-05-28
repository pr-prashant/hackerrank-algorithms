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

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Prashant Patel
 */
public class Java8Coding {

    public static void main(String[] args) {
        // Frequency of each character in string
/*
        String s = "jkahkdshflkjhaiehkjrnihadkjsbfgajhsdgfjhjwebnfvasdhgvfkghgqhjkewbrjk";
        Map<Character, Long> frequency = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);

        Map<Character, Long> frequency1 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.summingLong(l -> 1L)));
        System.out.println(frequency1);

        Map<Character, Long> frequency2 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.reducing(0L, l -> 1L, (a, b) -> a + b + 1)));
        System.out.println(frequency2);

        System.out.println(Stream.of(1 ,3, 4,2, 6,5, 7, 8).collect(Collectors.partitioningBy(i -> i%2 ==0)));


        int[] arr = new int[] {1, 2,3 ,2, 3, 1, 4, 5,2, 6, 7, 11, 12, 3, 9};

        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(collect);
*/

/*
        // Sort the list in reverse order
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 2, 3, 1, 4, 5, 2, 6, 7, 11, 12, 3, 9));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());

        // Join list of string with prefix, suffix and delimiter.
        List<String> strings = List.of("abc", "asdfa", "asd", "ttt", "jjjj");
        System.out.println(strings.stream().collect(Collectors.joining("-", "test", "new")));

        // Sort strings based on their length in increasing order
//        List<String> strings = List.of("abc", "asdfa", "asd", "ttt", "jjjj");
        System.out.println(strings.stream().sorted(Comparator.comparing(String::length)).toList());

//        Reverse an integer array
//        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 2, 3, 1, 4, 5, 2, 6, 7, 11, 12, 3, 9));
        int[] array = IntStream.rangeClosed(1, list.size()).map(i -> list.get(list.size() - i)).toArray();
        System.out.println(array);

//        Palindrome string check
        String s = "asddsa";
        boolean b = IntStream.rangeClosed(0, s.length() / 2).noneMatch(i -> s.charAt(i) != s.charAt(s.length() -1 - i));
        System.out.println(b);

//        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 2, 3, 1, 4, 5, 2, 6, 7, 11, 12, 3, 9));
        System.out.println(list.stream().skip(list.size() - 1).findFirst().orElse(null));
*/

        //Age of person in days
        String age = "2018-12-07";
        LocalDate date = LocalDate.parse(age);
        long between = ChronoUnit.YEARS.between(date, LocalDate.now());
        System.out.println(between);

        Stream.iterate(new int[]{0, 1}, f -> new int[] {f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).forEach(System.out::println);

        List<Integer> list = Stream.iterate(1, i -> i + 1).toList();

//        Find first non-repetitive character in a string
        String nonRep = "alkadsfasdfl";
        Arrays.stream(nonRep.split("")).map(s -> s.charAt(0)).filter(c -> nonRep.indexOf(c) != nonRep.lastIndexOf(c)).findFirst().get();

        List<Integer> test = List.of(1, 2, 3, 5, 6, 7, 8, 2, 4, 5, 6, 8, 9, 3, 3);
        test.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream().anyMatch(c -> c>=3);
    }
}
