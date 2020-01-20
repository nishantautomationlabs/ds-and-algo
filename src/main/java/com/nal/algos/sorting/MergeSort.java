package com.nal.algos.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 04/01/20.
 */

//    Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves,
//    calls itself for the two halves and then merges the two sorted halves.
//    The merge assumes that right and left sub-arrays are sorted and merges the two sorted sub-arrays into one
//    Merge sort is a Stable Sort
//    Merge sort is Non-Adaptive
//    Time complexity is O(NlogN), Space complexity is (log N)

public class MergeSort {
    private static int iteration = 1;

    public static void main(String[] args) {
        int[] arr = {5, 9, 6, 2, 4, 1, 8};
        int[] temp = new int[arr.length];
        System.out.println("Input:" + Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, temp, 0, arr.length - 1);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr, int[] temp, int start, int end) {
        if (start >= end)
            return;
        int middle = (start + end) / 2;
        sort(arr, temp, start, middle);
        sort(arr, temp, middle + 1, end);
        mergeHalves(arr, temp, start, end);
        System.out.println("Iteration:" + iteration++ + " Array:" + Arrays.toString(arr));
    }

    private void mergeHalves(int[] arr, int[] temp, int start, int end) {
        int middle = (start + end) / 2;
        int leftHalfIndex = start;
        int rightHalfIndex = middle + 1;
        int tempArrIndex = start;

        while (leftHalfIndex <= middle && rightHalfIndex <= end) {
            if (arr[leftHalfIndex] < arr[rightHalfIndex]) {
                temp[tempArrIndex] = arr[leftHalfIndex];
                leftHalfIndex++;
            } else {
                temp[tempArrIndex] = arr[rightHalfIndex];
                rightHalfIndex++;
            }
            tempArrIndex++;
        }
        System.arraycopy(arr, leftHalfIndex, temp, tempArrIndex, middle - leftHalfIndex + 1);
//        while (leftHalfIndex <= middle) {
//            temp[tempArrIndex++] = arr[leftHalfIndex++];
//        }
        System.arraycopy(arr, rightHalfIndex, temp, tempArrIndex, end - rightHalfIndex + 1);
//        while (rightHalfIndex <= end) {
//            temp[tempArrIndex++] = arr[rightHalfIndex++];
//        }
        System.arraycopy(temp, start, arr, start, end - start + 1);
//        for (int i = start; i <= end; i++) {
//            arr[i] = temp[i];
//        }
    }
}
