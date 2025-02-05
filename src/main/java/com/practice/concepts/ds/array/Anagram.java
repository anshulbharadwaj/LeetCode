package com.practice.concepts.ds.array;

import java.util.Arrays;

//Given two strings s and t, return true if t is anagram of s, and false otherwise
public class Anagram {

    public static boolean isAnagram(String s, String t) {
        /* Solution 1
        Fist method; time complexity O(n log n )
        char[] inputS = s.toCharArray();
        char[] inputT = t.toCharArray();

        Arrays.sort(inputS);
        Arrays.sort(inputT);
        return  Arrays.equals(inputS,inputT);
        */

        /* Solution 2
         * HashMap<Character,Integer> hashForS = new HashMap<>();
         * HashMap<Character,Integer> hashForT = new HashMap<>();
         * if(s.length()!=t.length()){
         * return false;
         * }
         * for(int i = 0; i < s.length();i++){
         * hashForS.merge(s.charAt(i),1,Integer::sum);
         * hashForT.merge(t.charAt(i),1,Integer::sum);
         * }
         * return hashForS.equals(hashForT);
         */

        // Solution 3
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("is Input an Anagram :" + isAnagram(s,t));

    }
}
