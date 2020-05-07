package com.nal.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 31/12/19.
 */
public class QuickSort3 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[end];
        int partitionIndex = partition(arr, start, end, pivot);
        System.out.println("partitionIndex " + start + " " + end + " " + partitionIndex);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex, end);
    }

    //O(nlogn) time (worst case O(n2) and O(1) space
    private static int partition(int[] arr, int start, int end, int pivot) {

        int leftPointer = start;
        int rightPointer = end - 1;
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot)
                leftPointer++;
            while (rightPointer > 0 && arr[rightPointer] > pivot)
                rightPointer--;
            if (leftPointer <= rightPointer) {
                swap(arr, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        swap(arr, leftPointer, end);
        return leftPointer;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
