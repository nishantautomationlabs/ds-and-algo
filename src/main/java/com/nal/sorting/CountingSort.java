package com.nal.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 01/03/20.
 * Different from comparison based sorting algorithms such as Merge sort, Quick sort etc
 * it assumes that the input elements are n integers in the range [0, k]. When k = O(n),
 * then the counting sort will run in O(n) time.
 * Used when input is in a range of values and/or frequently repeated
 * Stable Sorting Algorithm
 * Non-Adaptive Sorting Algorithm
 * Time Complexity O(N + K) - N is the number of elements and K is the input range
 * Space Complexity O(N + K) - O(N) to save result and O(k) to store counts
 */
public class CountingSort {

    public static void main(String[] args) {
        int arr[] = {6, 4, 3, 2, 1, 4, 3, 6, 6, 2, 4, 3, 4};
        System.out.println("Input:" + Arrays.toString(arr));
        CountingSort countingSort = new CountingSort();
        arr = countingSort.sort(arr, 6);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private int[] sort(int[] arr, int k) {
        int[] counts = new int[k + 1];
        for(int i : arr) {
            counts[i]++;
        }
        System.out.println(Arrays.toString(counts));
        for(int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }
        System.out.println(Arrays.toString(counts));
        int[] sortedArr = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            sortedArr[counts[arr[i]] - 1] = arr[i];
            counts[arr[i]]--;
        }
        return sortedArr;
    }
}
