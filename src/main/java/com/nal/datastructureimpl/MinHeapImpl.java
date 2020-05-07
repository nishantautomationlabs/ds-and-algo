package com.nal.datastructureimpl;

import java.util.Arrays;

/**
 * Created by nishant on 11/01/20.
 */
public class MinHeapImpl {

    private int capacity;
    private int size;
    private int[] arr;

    public MinHeapImpl(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    public int getRightChild(int index) {
        return arr[getRightChildIndex(index)];
    }

    public int getParent(int index) {
        return arr[getParentIndex(index)];
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public void ensureCapacity() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    //Time Complexity O(logN)
    public void push(int value) {
        ensureCapacity();
        arr[size++] = value;
        minHeapifyUp();
    }

    //Time Complexity O(logN)
    public int pop() {
        int value = arr[0];
        arr[0] = arr[size - 1];
        size = size - 1;
        minHeapifyDown();
        return value;
    }

    public int peek() {
        return arr[0];
    }

    public void minHeapifyDown() {
        int elementIndex = 0;
        while (hasLeftChild(elementIndex)) {
            int smallerChildIndex = getLeftChildIndex(elementIndex);
            if (hasRightChild(elementIndex) && getRightChild(elementIndex) < getLeftChild(elementIndex)) {
                smallerChildIndex = getRightChildIndex(elementIndex);
            }
            if (arr[elementIndex] < arr[smallerChildIndex])
                break;
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }
    }

    public void minHeapifyUp() {
        int elementIndex = size - 1;
        while (hasParent(elementIndex) && getParent(elementIndex) > arr[elementIndex]) {
            swap(getParentIndex(elementIndex), elementIndex);
            elementIndex = getParentIndex(elementIndex);
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i != size - 1)
                System.out.print(" --> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeapImpl heap = new MinHeapImpl(5);
        System.out.println("Size: " + heap.getSize());
        System.out.println("Capacity: " + heap.getCapacity());
        heap.push(20);
        heap.push(30);
        heap.push(10);
        heap.push(40);
        heap.push(5);
        heap.push(5);
        heap.push(50);
        heap.printHeap();
        System.out.println("Push 2");
        heap.push(2);
        heap.printHeap();
        System.out.println("Peek: " + heap.peek());
        heap.printHeap();
        System.out.println("Pop: " + heap.pop());
        heap.printHeap();
        System.out.println("Pop: " + heap.pop());
        heap.printHeap();
        System.out.println("Size: " + heap.getSize());
        System.out.println("Capacity: " + heap.getCapacity());
    }
}
