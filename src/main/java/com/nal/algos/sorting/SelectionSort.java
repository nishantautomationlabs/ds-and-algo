package com.nal.algos.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 03/01/20.
 */
//    repeated find the minimum element from unsorted part and putting it at the beginning
//    Unstable sorting algorithm
//    Selection sort is non-adaptable.The order of elements does not affect the sorting time.
//    In other words, even if the array is partially sorted, still each element is compared and there is no breaking out early.
//    Selection Sort makes O(N) swap
//    Time complexity is O(N^2), Space complexity is O(1).
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 6, 2, 4, 1, 8};
        System.out.println("Input:" + Arrays.toString(arr));
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr, arr.length);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr, int n) {
        for (int i = 0; i <= n - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
            System.out.println("Iteration:" + (i + 1) + " Array:" + Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
