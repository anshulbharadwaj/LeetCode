package com.practice.concepts.ds.array;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 * <p>
 * Input: nums = [ 1, 2, 3, 4]
 * Output: [ 1, 3, 6, 10]
 */

public class RunningSumOptimalSolution {

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] inputArr = {1, 2, 3, 4};
        int[] resultArray = runningSum(inputArr);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}
