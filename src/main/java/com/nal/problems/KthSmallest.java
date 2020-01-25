package com.nal.problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nishant on 02/01/20.
 */
public class KthSmallest {

    public static void main(String[] args) {
        Integer[] arr = {12, 3, 2, 7, 4, 19, 26, 1, 5};
//        int[] arr = {5, 9, 6, 2, 4, 1, 8};
        int k = 7;
//        int kthSmallest = kthSmallestUsingSort(arr, k);
//        int kthLargest = kthLargestUsingSort(arr, k);
        int kthSmallest = kthSmallestUsingQuickSelect(arr, 0, arr.length - 1, k);
        System.out.println(Arrays.toString(arr));
        System.out.println(kthSmallest);
    }

    private static int kthSmallestUsingSort(Integer[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    private static int kthLargestUsingSort(Integer[] arr, int k) {
        Arrays.sort(arr, Collections.reverseOrder()); //need Integer[] array instead of int[] as it takes T type object
        return arr[k - 1];
    }

    private static int kthSmallestUsingQuickSelect(Integer[] arr, int start, int end, int k) {
//        int pIndex = partition(arr, start, end);
//        int pIndex = partitionUsingStreams(arr, start, end);
//        int pIndex = partition(arr, start, end);
        int pIndex = randomPartition(arr, start, end);
//        System.out.println("pIndex " + pIndex);
        if (k - 1 == pIndex - start)
            return arr[pIndex];
        else if (k - 1 < pIndex - start) {
//            System.out.println("LESS");
//            System.out.println("k = " + k + " start = " + start + " end = " + end + " pindex = " + pIndex);
//            System.out.println("pIndex -1 " + (pIndex - 1) + " end " + end + " k " + k);
            return kthSmallestUsingQuickSelect(arr, start, pIndex - 1, k);
        } else {
//            System.out.println("MORE");
//            System.out.println("k = " + k + " start = " + start + " end = " + end + " pindex = " + pIndex);
//            System.out.println("pIndex + 1 " + (pIndex + 1) + " end " + end + " k " + (k + start - pIndex - 1));
            return kthSmallestUsingQuickSelect(arr, pIndex + 1, end, k + start - pIndex - 1);
        }
    }

    private static int partition(Integer[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex++);
            }
        }
        swap(arr, end, pIndex);
        return pIndex;
    }

    private static int randomPartition(Integer[] arr, int start, int end) {
        int n = end - start + 1;
        int randomPivot = (int) (Math.random() * n);
        swap(arr, start + randomPivot, end);
        return partition(arr, start, end);

    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
