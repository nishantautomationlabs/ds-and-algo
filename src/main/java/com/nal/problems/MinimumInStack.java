package com.nal.problems;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nishant on 10/01/20.
 */
public class MinimumInStack extends Stack<Integer> {

    private Stack<Integer> minStack;

    public MinimumInStack() {
        this.minStack = new Stack<>();
    }

    public Integer push(Integer value) {
        super.push(value);
        if (minStack.empty() || value <= min())
            minStack.push(value);
        return value;
    }

    public Integer pop() {
        Integer value = super.pop();
        if (value == min())
            minStack.pop();
        return value;
    }

    public Integer min() {
        if (minStack.empty())
            return Integer.MAX_VALUE;
        else
            return minStack.peek();
    }

    public void printStack()
    {
        System.out.println("Original Stack");
        printStackInternal(this);
        System.out.println("Minimum Stack");
        printStackInternal(this.minStack);
    }

    private void printStackInternal(Stack<Integer> stack) {
        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
//        Stack<Integer> integerStack = new Stack<>();
//        integerStack.search()

        MinimumInStack minimumInStack = new MinimumInStack();
        minimumInStack.push(5);
        minimumInStack.push(7);
        minimumInStack.push(3);
        minimumInStack.push(4);
        minimumInStack.printStack();
        System.out.println("Min:" + minimumInStack.min());
        System.out.println("Pop out " + minimumInStack.pop());
        System.out.println("Pop out " + minimumInStack.pop());
        System.out.println("Min:" + minimumInStack.min());
        minimumInStack.printStack();



    }
}
