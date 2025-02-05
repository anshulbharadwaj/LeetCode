package com.practice.concepts.string;

/**
 * Convert a non-negative integer num to its English words representation.
 * Example 1:
 * <p>
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglish {

    private static final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        return convertToWord(num);
    }

    public static String convertToWord(int num) {
        if (num < 10)
            return belowTen[num];
        if (num < 20)
            return belowTwenty[num - 10];
        if (num < 100) {
            return belowHundred[num / 10] + (num % 10 != 0 ? " " + convertToWord(num % 10) : "");
        }
        if (num < 1000) {
            return convertToWord(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convertToWord(num % 100) : "");
        }
        if (num < 1000000) {
            return convertToWord(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWord(num % 1000) : "");
        }
        if (num < 1000000000) {
            return convertToWord(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convertToWord(num % 1000000) : "");
        }
        return convertToWord(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWord(num % 1000000000) : "");
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(99999999));
    }
}
