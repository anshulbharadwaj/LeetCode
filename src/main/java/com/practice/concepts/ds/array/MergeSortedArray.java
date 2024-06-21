package com.practice.concepts.ds.array;

/**
 * You are given two integer arrays nums1 and nums2,
 * sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n
 */
public class MergeSortedArray {
    public void merge(int[] num1, int m, int[] num2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && num1[i] > num2[j]) {
                num1[k] = num1[i];
                k--;
                i--;
            } else {
                num1[k] = num2[j];
                k--;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(num1, m, num2, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(num1[i] + " ");
        }
    }
}
