package com.nal.datastructures.javainternal;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nishant on 10/01/20.
 */
public class JavaStack {

    public static void main(String[] args)
    {
        Stack<Integer> integerStack = new Stack<>();
        System.out.println("Is Empty: " + integerStack.empty());
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(null);
        integerStack.push(4);
        System.out.println("Is Empty: " + integerStack.empty());

        printStack(integerStack);
        System.out.println("Peek: " + integerStack.peek());
        System.out.println("Pop: " + integerStack.pop());
        System.out.println("Pop: " + integerStack.pop());
        integerStack.push(9);
        printStack(integerStack);
        System.out.println("Search 1: "+ integerStack.search(1));  //count from stack top
        System.out.println("Size: " + integerStack.size());
        System.out.println("Capacity: " + integerStack.capacity());
        integerStack.setSize(11);
        System.out.println("Size: " + integerStack.size());
        System.out.println("Capacity: " + integerStack.capacity());
        printStack(integerStack);
    }

    public static void printStack(Stack<Integer> stack)
    {
        Iterator iterator = stack.iterator();
        while(iterator.hasNext())
        {
            System.out.print(iterator.next());
            if(iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }
}
