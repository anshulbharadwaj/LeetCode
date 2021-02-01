package com.practice.concepts.ds.array;

public class MaximumAndMinimum {

    static class MaxMinPair {
        int max;
        int min;
    }

    /**
     * This method finds max and min element for given input numbers.
     *
     * @param numbers input Numbers
     * @return pair of max and min element
     */
    public static MaxMinPair findMaxAndMin(int[] numbers) {
        int length = numbers.length;
        MaxMinPair minMax = new MaxMinPair();

         //If there is only one element, return it as max and min
        if (length == 1) {
            minMax.max = numbers[0];
            minMax.min = numbers[0];
            return minMax;
        }
        if (numbers[0] > numbers[1]) {
            minMax.max = numbers[0];
            minMax.min = numbers[1];
        } else {
            minMax.max = numbers[1];
            minMax.min = numbers[0];
        }

        for (int i = 2; i < length; i++) {
            if (numbers[i] > minMax.max) {
                minMax.max = numbers[i];
            } else if (numbers[i] < minMax.min) {
                minMax.min = numbers[i];
            }
        }
        return minMax;
    }

    /**
     * Runner for testing findMaxAndMin ()
     * @param args args
     */
    public static void main(String[] args) {
        int[] inputNumbers = {1000, 11, 445, 1, 330, 3000};
        MaxMinPair maxMinPair = findMaxAndMin(inputNumbers);
        System.out.println("Min element is:: " + maxMinPair.min);
        System.out.println("Max element is:: " + maxMinPair.max);
    }
}