package com.nal.algos.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 03/01/20.
 */

//    repeatedly swap the adjacent elements if they are in wrong order until they are sorted.
//    Stable sorting algorithm
//    Bubble sort is adaptive. If the array is partially sorted, we'll terminate the sorting loop early.
//    Bubble Sort makes O(N^2) swaps
//    Time complexity is O(N^2), Space complexity is O(1).
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 6, 2, 4, 1, 8};
        System.out.println("Input:" + Arrays.toString(arr));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr, arr.length);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr, int length) {
        boolean isSorted = false;
        int index = length - 1;
        int iteration = 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < index; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            System.out.println("Iteration:" + iteration++ + " Array:" + Arrays.toString(arr));
            index--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
