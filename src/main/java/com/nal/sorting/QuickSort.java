package com.nal.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by nishant on 31/12/19.
 */

//    QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array
//    around the picked pivot such that all element smaller than the pivot are before the element greater than the pivot
//    Quick sort is not a Stable Sort
//    Quick sort is Non-Adaptive
//    Time complexity is O(NlogN) worst case O(N^2), Space complexity is (log N)
//    The in-place partition logic uses O(1) space and the recursive quick sort algorithm takes O(log N) space.
//    So the overall space complexity of quick sort if O(log N)
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 9, 6, 2, 4, 1, 8};
//        int[] arr = {4, 6, 3, 2, 7, 5};
//        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(Integer[] arr, int start, int end) {
        if (start >= end)
            return;

//        int partitionIndex = partitionUsingStreams(arr, start, end);
        int partitionIndex = randomPartition(arr, start, end);
//        int partitionIndex = partition(arr, start, end);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    private static int randomPartition(Integer[] arr, int start, int end) {
        int n = end - start + 1;
        int randomPivot = (int) (Math.random() * n);
        swap(arr, start + randomPivot, end);
        return partition(arr, start, end);

    }

    private static int partition(Integer[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static int partitionUsingStreams(Integer[] arr, int start, int end) {
        int pivot = arr[end];
        Integer[] leftArr;
        Integer[] rightArr;

        leftArr = IntStream.range(start, end)
                .filter(i -> arr[i] < pivot)
                .map(i -> arr[i])
                .boxed()
                .toArray(Integer[]::new);

        rightArr = IntStream.range(start, end)
                .filter(i -> arr[i] > pivot)
                .map(i -> arr[i])
                .boxed()
                .toArray(Integer[]::new);

        System.arraycopy(leftArr, 0, arr, start, leftArr.length);
        int pIndex = start + leftArr.length;
        arr[pIndex] = pivot;
        System.arraycopy(rightArr, 0, arr, pIndex + 1, rightArr.length);
        return pIndex;
    }

    private static void swap(Integer[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
