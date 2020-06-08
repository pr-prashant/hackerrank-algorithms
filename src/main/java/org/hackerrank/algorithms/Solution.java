package org.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Prashant Patel (312455)
 * Date: 3/11/2020
 **/
public class Solution {

    private static final String WINTER = "WINTER";
    private static final String SPRING = "SPRING";
    private static final String SUMMER = "SUMMER";
    private static final String AUTUMN = "AUTUMN";

    public String solution(int[] T) {
        // write your code in Java SE 8
        int totalDays = T.length/4;
        List<Integer> seasons = Arrays.stream(T).boxed().collect(Collectors.toList());
        List<Integer> winter = seasons.subList(0, totalDays);
        List<Integer> spring = seasons.subList(totalDays, totalDays*2);
        List<Integer> summer = seasons.subList(totalDays*2, totalDays*3);
        List<Integer> autumn = seasons.subList(totalDays*3, totalDays*4);

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(getTempDiff(winter), WINTER);
        map.put(getTempDiff(spring), SPRING);
        map.put(getTempDiff(summer), SUMMER);
        map.put(getTempDiff(autumn), AUTUMN);

        return map.lastEntry().getValue();
    }

    private int getTempDiff(List<Integer> list) {
        return Collections.max(list) - Collections.min(list);
    }
}
