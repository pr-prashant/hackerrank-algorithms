package org.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Prashant Patel
 */
public class StrobogrammaticNumber {

    public static boolean isStrobogrammatic(int n) {
        String s = String.valueOf(n);
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Test method
    public static void main(String[] args) {
//        System.out.println(isStrobogrammatic(69));     // true
//        System.out.println(isStrobogrammatic(88));     // true
//        System.out.println(isStrobogrammatic(962));    // false
//        System.out.println(isStrobogrammatic(818));    // true
        System.out.println(isStrobogrammatic(8000));   // true
    }
}

