package com.nal.problems;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nishant on 10/01/20.
 */
public class MaximumInStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaximumInStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(Integer value) {
        stack.push(value);
        if (maxStack.empty() || maxStack.peek() <= value) {
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
        if(maxStack.empty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }

    public void printStacks() {
        System.out.print("Stack is ");
        printStack(stack);
        System.out.print("Max Stack is ");
        printStack(maxStack);
    }

    public void printStack(Stack<Integer> stack) {
        if(stack.empty()) {
            System.out.println("Empty");
            return;
        }
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
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
