package com.practice.concepts.ds.array;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 * <p>
 * Input: nums = [ 1, 2, 3, 4]
 * Output: [ 1, 3, 6, 10]
 */
public class RunningSumLongSolution {
    public static int[] runningSum(int[] nums) {
        int[] running = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumOfNumbers(i, nums, running);
        }
        return running;
    }

    public static int[] sumOfNumbers(int index, int[] input, int[] running) {
        int sum = 0;
        if (index == 0) {
            running[index] = input[index];
        } else if (index > 0) {
            int cur = index;
            while (index >= 0) {
                sum = sum + input[index];
                index--;
            }
            running[cur] = sum;
        }
        return running;

    }

    public static void main(String[] args) {
        int[] inputArr = {1, 2, 3, 4};
        int[] resultArray = runningSum(inputArr);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}

