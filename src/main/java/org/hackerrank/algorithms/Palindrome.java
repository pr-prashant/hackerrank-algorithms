package org.hackerrank.algorithms;

public class Palindrome {

    public static void main(String[] args) {
        //System.out.println(String.format("Is %s a palindrome? : %s", "Infobip", isPalindrome("Infobip")));
        //System.out.println(String.format("Is %s a palindrome? : %s", "deleveled", isPalindrome("deleveled")));
        //System.out.println(String.format("Is %s a palindrome? : %s", "refer", isPalindrome("refer")));

        System.out.println(String.format("Is %s a palindrome? : %s", "Lonely   Tylenol",
                isPalindrome("Lonely   Tylenol")));
    }

    public static boolean isPalindrome(String testString) {
        String test = testString.toLowerCase().trim();
        int i= 0,j=test.length()-1;
        while(i<j){
            if(test.charAt(i) != test.charAt(j)){
                return false;
            }
            i++;
            j--;
        }


        return true;
    }
}
