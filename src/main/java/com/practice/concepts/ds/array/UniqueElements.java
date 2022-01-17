package com.practice.concepts.ds.array;

import java.util.HashMap;
import java.util.Map;

public class UniqueElements {
    public static int sumOfUnique(int[] nums) {
        int sum = 0;
        if (nums.length == 1) {
            sum = nums[0];
            return sum;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

        }
        if (map.size() == 1) {
            return sum;
        }

        if (map.size() > 1) {
            sum = map
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .reduce(0, Integer::sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        //int [] inputNumbers = {1,2,3,2};
        //int[] inputNumbers = {1, 1, 1, 1};
        int[] inputNumbers = {1, 2, 3, 4, 5};
        int answer = UniqueElements.sumOfUnique(inputNumbers);
        System.out.println("answer is " + answer);

    }
}
