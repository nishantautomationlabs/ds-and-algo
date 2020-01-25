package com.nal.datastructures.impl;

import java.util.EmptyStackException;

/**
 * Created by nishant on 10/01/20.
 */
public class StackImpl<T> {

    private int size;
    private T[] arr;
    private int top;

    public StackImpl(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public StackImpl() {
        this(10);
    }

    //Time Complexity: O(1)
    public void push(T value) {
        if (isFull())
            throw new IllegalStateException();
        arr[++top] = value;
    }

    //Time Complexity: O(1)
    public T pop() {
        if (top < 0)
            throw new EmptyStackException();
        return arr[top--];
    }

    public T peek() {
        if (top < 0)
            throw new EmptyStackException();
        return arr[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0)
                System.out.print(" --> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<>();
        System.out.println("Stack Is Empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println("Stack Is Full: " + stack.isFull());
        stack.print();
        System.out.println("Peek:" + stack.peek());
        System.out.println("Pop:" + stack.pop());
        System.out.println("Pop:" + stack.pop());
        System.out.println("Pop:" + stack.pop());
        stack.print();
    }

}
