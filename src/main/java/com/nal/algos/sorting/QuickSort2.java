package com.nal.algos.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 31/12/19.
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 7, 5, 9, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[(end+start)/2];
        int partitionIndex = partition(arr, start, end, pivot);
        System.out.println("partitionIndex " + start + " " + end + " " + partitionIndex);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex, end);
    }

    //O(nlogn) time (worst case O(n2) and O(1) space
    private static int partition(int[] arr, int start, int end, int pivot) {

        while (start <= end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
