package com.nal.problems;

import com.nal.datastructures.impl.StackImpl;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nishant on 10/01/20.
 */
public class MaximumInStack {

    private StackImpl<Integer> stack;
    private StackImpl<Integer> maxStack;

    public MaximumInStack() {
        this.stack = new StackImpl<>();
        this.maxStack = new StackImpl<>();
    }

    public void push(Integer value) {
        stack.push(value);
        if (maxStack.isEmpty() || maxStack.peek() <= value) {
            maxStack.push(value);
        }
    }

    public Integer pop() {
        Integer value = stack.pop();
        System.out.println("Popped " + value);
        if (maxStack.peek() == value)
            maxStack.pop();
        return value;
    }

    public Integer getMax() {
        if(maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }

    public void printStacks() {
        System.out.print("Stack is ");
        stack.print();
        System.out.print("Max Stack is ");
        maxStack.print();
    }

    public static void main(String[] args) {
        MaximumInStack maximumInStack = new MaximumInStack();
        maximumInStack.push(20);
        maximumInStack.push(30);
        maximumInStack.push(10);
        maximumInStack.push(40);
        maximumInStack.push(50);
        maximumInStack.push(5);
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
        System.out.println("Max is " + maximumInStack.getMax());
        maximumInStack.pop();
        maximumInStack.printStacks();
    }
}
