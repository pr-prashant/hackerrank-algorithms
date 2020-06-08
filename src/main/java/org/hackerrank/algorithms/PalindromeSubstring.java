package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Prashant Patel (312455)
 * Date: 3/15/2020
 **/
public class PalindromeSubstring {

    private static String findPalindromeSubString(String str) {
        String sub = null;
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        stack.push(chars[0]);
        stack.push(chars[1]);
        StringBuilder builder = new StringBuilder();
        char tmpChar;
        int i=2;
        while(i<chars.length) {
            char currChar = chars[i];
            char c1 = stack.pop();
            char c2 = stack.pop();
            if(c1 == currChar) {
                System.out.println(c1);
                builder.append(c1);
                stack.push(c2);
                i++;
                continue;
            } else if(c2 == currChar) {
                tmpChar = c1;
                builder.append(tmpChar);
                System.out.println( tmpChar);
                builder.append(c2);
                System.out.println(c2);
                i++;
                continue;
            } else {
                stack.push(c2);
                stack.push(c1);
            }
            i++;
            stack.push(currChar);
        }
        System.out.println(builder);
        return sub;
    }

    private static void findPalindrome(String input) {
        String formattedInput = "@" + input + "#";

        char inputCharArr[] = formattedInput.toCharArray();
        int radius[][] = new int[2][input.length() + 1];

        Set<String> palindromes = new HashSet<>();
        int max;
        for (int j = 0; j <= 1; j++) {
            radius[j][0] = max = 0;
            int i = 1;
            while (i <= input.length()) {
                palindromes.add(Character.toString(inputCharArr[i]));
                while (inputCharArr[i - max - 1] == inputCharArr[i + j + max])
                    max++;
                radius[j][i] = max;
                int k = 1;
                while ((radius[j][i - k] != max - k) && (k < max)) {
                    radius[j][i + k] = Math.min(radius[j][i - k], max - k);
                    k++;
                }
                max = Math.max(max - k, 0);
                i += k;
            }
        }
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                for (max = radius[j][i]; max > 0; max--) {
                    palindromes.add(input.substring(i - max - 1, max + j + i - 1));
                }
            }
        }
        System.out.println(palindromes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
//        System.out.println(findPalindromeSubString(n));
        findPalindrome(n);
    }
}