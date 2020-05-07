package com.nal.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 03/01/20.
 */
//    create a hole from ith position, move the elements from the left sorted subarray by 1 index right if the element is
//    smaller than value taken from ith position and then insert that element at the hole index
//    Stable sorting algorithm. As elements bubble to the correct position in the sorted area of the array,
//    the original relative order of equal elements are maintained.
//    Insertion sort is adaptive. If the array is partially sorted, we'll terminate the sorting loop early. In other words,
//    nearly sorted arrays complete very quickly
//    Insertion Sort makes O(N^2) swaps to get all elements in the correct place
//    Time complexity is O(N^2), Space complexity is O(1).
//    The worst case is when the entire array is sorted in descending order. In that case, we have to check N elements
//    and swap N elements for each selected element.
public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {5, 9, 6, 2, 4, 1, 8};
        System.out.println("Input:" + Arrays.toString(arr));
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr, arr.length);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void insertionSort(int[] arr, int n) {
        for (int i = 1; i <= n - 1; i++) {
            int value = arr[i];
            int holeIndex = i - 1;
            while (holeIndex >= 0 && arr[holeIndex] > value) {
                arr[holeIndex + 1] = arr[holeIndex];
                holeIndex--;
            }
            arr[holeIndex + 1] = value;
            System.out.println("Iteration:" + i + " Array:" + Arrays.toString(arr));
        }
    }
}
