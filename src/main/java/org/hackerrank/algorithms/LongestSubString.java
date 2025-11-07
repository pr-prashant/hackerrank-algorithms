package org.hackerrank.algorithms;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Prashant Patel
 */
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (seen.contains(c)) {
                char ci = s.charAt(i);
                seen.remove(ci);
                i++;
            } else {
                seen.add(c);
                j++;
                maxLength = Math.max(j - i, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubString l = new LongestSubString();
        System.out.println(l.lengthOfLongestSubstring("egheskg"));
    }
}
