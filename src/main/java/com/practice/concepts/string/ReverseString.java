package com.practice.concepts.string;

/**
 * Given a string, that contains special character together with alphabets ('a' to 'z'
 * and 'A' to 'Z'), reverse the string in a way that special characters are not affected.
 */
public class ReverseString {

    public static void reverse(char[] input) {
        int end = input.length - 1;
        int start = 0;

        while (start < end) {
            if (!Character.isAlphabetic(input[start])) {
                start++;
            } else if (!Character.isAlphabetic(input[end])) {
                end--;
            } else {
                char temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = "abc$ %ret y#r"; // "a!!!b.c.d,e'f,ghi"
        String[] in = s.split(" ");
        char[] abc = new char[in.length];
        for (String toConvert : in) {
            abc = toConvert.toCharArray();
            reverse(abc);
            sb.append(abc);
            sb.append(" ");
        }
        System.out.println("Input String is: " + s);
        System.out.println("Output String is: " + sb.toString());
    }
}
