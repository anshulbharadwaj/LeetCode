package com.practice.concepts.ds.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] numbers) {
        /*for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) { //  comparisons to elements before the current element
                if (numbers[i] == numbers[j]) return true;
            }
        }
        return false; */

        Set<Integer> set = new HashSet<>(numbers.length);
        for(int a: numbers){
            if(set.contains(a))return true;
            set.add(a);
        }
        return false;
    }

    public static void main(String[] args) {
        int [] input = { 1, 2, 3, 1}; //3
        //System.out.println(containsDuplicate(input));
        int a = 12345;
        int b= 1000;
        int c = a%b;
        int d = 23;
        int e = 10;
        System.out.println(99/10);
        System.out.println(a%b);
    }
}
