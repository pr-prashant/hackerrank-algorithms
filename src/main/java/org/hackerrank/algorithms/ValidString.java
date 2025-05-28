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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Prashant Patel
 */
public class ValidString {

    /*public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> openParenthesis = Set.of('(', '{', '[');
        Set<Character> closedParenthesis = Set.of(')', '}', ']');
        Map<Character, Character> closedOpenMap = Map.of('}', '{', ']', '[', ')', '(');
        if (s != null) {
            if (closedParenthesis.contains(s.charAt(0)))
                return false;
        } else {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (openParenthesis.contains(ch)) {
                stack.push(ch);
            } else if (closedParenthesis.contains(ch) && !stack.isEmpty()) {
                char c = stack.pop();
                if (c != closedOpenMap.get(ch)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }*/

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closedOpenMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (closedOpenMap.containsValue(ch)) {
                stack.push(ch);
            } else if (closedOpenMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != closedOpenMap.get(ch)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidPalindrome(String s) {
        if (s == null || s.trim().isEmpty()) {
            return true;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9$]", "");
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("()"));
        System.out.println(isValidPalindrome("Ab  ,.c1d-+=1cba"));
    }
}
