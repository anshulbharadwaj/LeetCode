package com.practice.concepts.ds.array;

import java.util.stream.IntStream;

public class ReverseArray {

    /**
     *  This method reverses the array elements from start to end.
     *  1. swap arr[start] with arr[end] and change start and end as::
     *  2. start = start + 1 and end = end - 1;
     * @param inputNumbers input Numbers
     */
    public void reverseArray(int [] inputNumbers) {
        int end = inputNumbers.length;
        int start = 0;
        while (start < end) {
            int startValue = inputNumbers[start];
            int endValue = inputNumbers[end - 1];
            inputNumbers[start] = endValue;
            inputNumbers[end-1] = startValue;
            start++;
            end--;
        }
    }

    /**
     * This method print elements of array
     * @param inputNumbers input numbers
     */
    public void printElements(int [] inputNumbers) {
        IntStream.range(0,inputNumbers.length).forEach(
                s-> System.out.print(" " + inputNumbers[s]));
    }

    /**
     *  Runner code
     * @param args
     */
    public static void main(String[] args) {
        int [] numbers = { 2,7,4,9,1,6 }; // 6 1 9 4 7 2
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverseArray(numbers);
        reverseArray.printElements(numbers);
    }
}
