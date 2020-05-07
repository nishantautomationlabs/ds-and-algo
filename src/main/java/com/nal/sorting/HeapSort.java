package com.nal.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 11/01/20.
 */

//    Heap sort is a comparison based sorting technique based on Binary Heap data structure.
//    It is similar to selection sort where we first find the maximum element and place the maximum element at the end.
//    We repeat the same process for remaining element.
//    Heap sort is not a Stable Sort but can be made stable
//    Heap sort is Non-Adaptive
//    Time complexity is O(NlogN), Space complexity is O(1)
public class HeapSort {

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getLeftChild(int[] arr, int index) {
        return arr[getLeftChildIndex(index)];
    }

    public boolean hasLeftChild(int n, int index) {
        return getLeftChildIndex(index) < n;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getRightChild(int[] arr, int index) {
        return arr[getRightChildIndex(index)];
    }

    public boolean hasRightChild(int n, int index) {
        return getRightChildIndex(index) < n;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 6, 2, 4, 1, 8};
        System.out.println("Input:" + Arrays.toString(arr));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, arr.length);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr, int n) {
        maxHeapifyArray(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            maxHeapifyDown(arr, i, 0);
        }
    }

    //Time Complexity O(N)
    private void maxHeapifyArray(int[] arr, int n) {
        for (int index = (n / 2) - 1; index >= 0; index--) {
            maxHeapifyDown(arr, n, index);
        }
    }

    private void maxHeapifyDown(int[] arr, int n, int index) {
        while (hasLeftChild(n, index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(n, index) && getRightChild(arr, index) > getLeftChild(arr, index))
                largerChildIndex = getRightChildIndex(index);

            if (arr[index] > arr[largerChildIndex])
                break;
            swap(arr, index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
