package com.practice.concepts.ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 * Input:
 * N = 5
 * arr[] = {0 2 1 2 0}
 * Output:
 * 0 0 1 2 2
 * Explanation:
 * 0s 1s and 2s are segregated into ascending order
 */
public class SortArrayW {

    public static void sortElements(int[] a, int n) {
        int[] sorted = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            int key = num.getKey();
            int value = num.getValue();
            if (key == 0) {
                while (value-- > 0) {
                    sorted[i] = key;
                    i++;
                }
            }
            if (key == 1) {
                while (value-- > 0) {
                    sorted[i] = key;
                    i++;
                }
            }
            if (key == 2) {
                while (value-- > 0) {
                    sorted[i] = key;
                    i++;
                }
            }
        }

        for (int is = 0; is < sorted.length; is++) {
            System.out.print(sorted[is] + " ");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0, 2, 1, 2, 0};
        //int[] numbers = {0, 1, 0};

        int sizein = 5;
        //int sizein = 3;
        sortElements(numbers, sizein);
    }
}
