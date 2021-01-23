package com.practice.concepts.sorting;

public class InsertionSort {

    // 3,1,5,7,2

    /** This method sorts array using insertion sort technique.
     * To sort an array of size n in ascending order:
     * 1: Iterate from arr[1] to arr[n] over the array.
     * 2: Compare the current element (key) to its predecessor.
     * 3: If the key element is smaller than its predecessor, compare it to the elements before.
     * Move the greater elements one position up to make space for the swapped element.
     * @param elements inputArray
     */
    public static void sortArray(int[] elements) {
        int size = elements.length;

        for (int i = 1; i < size; i++) {
            /*int key = elements[i-1];
            int j = i-1;
            while(key>=0 && key > elements[i]) {
                int temp = elements[i];
                elements[i-1] = elements[i];
                elements[i] = key;
                key = key -1;*/

            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && key < elements[j]) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        /*int[] inputNumbers = new int[]{3,1,5,7,2};
        sortArray(inputNumbers);*/
        int[] inputNumbers;
        inputNumbers = new int[]{3, 1, 5, 7, 2};
        sortArray(inputNumbers);
        printElements(inputNumbers);
    }

    static void printElements(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }
}
