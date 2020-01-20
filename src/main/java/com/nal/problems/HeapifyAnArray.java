package com.nal.problems;

/**
 * Created by nishant on 11/01/20.
 */
public class HeapifyAnArray {

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getLeftChild(int[] arr, int index) {
        return arr[getLeftChildIndex(index)];
    }

    public int getRightChild(int[] arr, int index) {
        return arr[getRightChildIndex(index)];
    }

    public boolean hasLeftChild(int[] arr, int index) {
        return getLeftChildIndex(index) < arr.length;
    }

    public boolean hasRightChild(int[] arr, int index) {
        return getRightChildIndex(index) < arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 40, 5, 5, 50, 2};
        HeapifyAnArray heapify = new HeapifyAnArray();
        int n = arr.length;
        heapify.minHeapifyArray(arr, n);
        heapify.printHeap(arr, n);
    }

    private void minHeapifyArray(int[] arr, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            minHeapifyDown(arr, i);
        }
    }

    private void minHeapifyDown(int[] arr, int index) {
        while (hasLeftChild(arr, index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(arr, index) && getRightChild(arr, index) < getLeftChild(arr, index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(arr[index] < arr[smallerChildIndex])
                break;
            swap(arr, index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printHeap(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1)
                System.out.print(" --> ");
        }
        System.out.println();
    }

}
