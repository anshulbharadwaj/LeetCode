package com.practice.concepts.string;

import java.util.*;

public class LongestSubstring {
    public int calculateLongestSubstring(String s) {

        if (s.length() < 1) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int leftPointer = 0, rightPointer = 0, max = 0; //a b c a b c b b
        Set<Character> set = new HashSet<>();
        while (rightPointer < s.length()) {
            if (!set.contains(s.charAt(rightPointer))) {
                set.add(s.charAt(rightPointer++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(leftPointer++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();
        //substring.calculateLongestSubstring("abcabcbb"); //pwwkew
        System.out.println(substring.calculateLongestSubstring("abcabcbb"));
    }
}
