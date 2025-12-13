package com.pangoo;

import java.util.Map;

public class RomanToInteger {
    Map<String, Integer> romanNum = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();

        System.out.println(rti.romanToInt("LVIII"));
        System.out.println(rti.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        String[] chars = s.split("");
        int charLength = chars.length;
        int sum = 0;
        for (int i = 0; i < charLength; i++) {
            int num = romanNum.get(chars[i]);
            int nextNum = 0;
            if (i + 1 < chars.length) {
                nextNum = romanNum.get(chars[i + 1]);
            }

            if (num >= nextNum) {
                sum = sum + num;
            } else {
                sum = sum - num;
            }
        }

        return sum;
    }

}
