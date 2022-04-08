package com.practice.concepts.string;

public class RomanToInt {

    public static int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) { // till second last character
            int currentValue = getValue(s.charAt(i));
            int nextValue = getValue(s.charAt(i + 1));

            if (currentValue < nextValue) {
                res = res - currentValue; // for cases like "IV", "IX"
            } else {
                res = res + currentValue; // for normal case like 'C', 'D', 'I'
            }
        }

        int lastCharacterValue = getValue(s.charAt(len - 1)); // add last char also

        return res + lastCharacterValue;

    }

    private static int  getValue(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else return 1000;

    }

    public static void main(String[] args) {
        romanToInt("III");
    }
}
