package com.practice.concepts.ds.array;

public class ReverseInteger {
    public static int reverse(int x) {
        long reverseNumber = 0;
        while (x != 0) {
            int rem = x % 10;
            x = x / 10;
            reverseNumber = reverseNumber * 10 + rem;
        }
        if (reverseNumber > (long) Integer.MAX_VALUE
                || reverseNumber < (long) Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverse(297));
    }
}
