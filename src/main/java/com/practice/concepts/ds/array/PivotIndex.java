package com.practice.concepts.ds.array;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int leftSum=0, rightSum=0;
        for(int num:nums){
            rightSum = rightSum+num;

        }
        for(int i=0;i<nums.length;i++){
            rightSum = rightSum - nums[i];
            if(leftSum==rightSum) return i;
            leftSum = leftSum+nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        int num [] = {1,7,3,6,5,6};
        int result = pivotIndex(num);
        System.out.println(result);
    }
}
