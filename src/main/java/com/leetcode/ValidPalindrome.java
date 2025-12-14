package com.leetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));

    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();

        int head = 0;
        int tail = charArray.length - 1;

        while (head < tail) {
            if(!Character.isLetterOrDigit(charArray[head])){
                head++;
                continue;
            }

            if(!Character.isLetterOrDigit(charArray[tail])){
                tail--;
                continue;
            }

            if (Character.toLowerCase(charArray[head]) != Character.toLowerCase(charArray[tail])){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
