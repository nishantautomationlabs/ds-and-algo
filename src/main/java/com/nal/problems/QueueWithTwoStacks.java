package com.nal.problems;

import java.util.Stack;

/**
 * Created by nishant on 20/01/20.
 */
public class QueueWithTwoStacks<T> {
    private Stack<T> stackWithNewestOnTop;
    private Stack<T> stackWithOldestOnTop;

    public QueueWithTwoStacks() {
        stackWithNewestOnTop = new Stack<>();
        stackWithOldestOnTop = new Stack<>();
    }

    public void enqueue(T value) {
        stackWithNewestOnTop.push(value);
    }

    public T peek() {
        moveValuesToOldestOnTopStack();
        if (stackWithOldestOnTop.isEmpty())
            throw new IllegalStateException();
        return stackWithOldestOnTop.peek();
    }

    private void moveValuesToOldestOnTopStack() {
        if (stackWithOldestOnTop.isEmpty()) {
            while (!stackWithNewestOnTop.isEmpty()) {
                stackWithOldestOnTop.push(stackWithNewestOnTop.pop());
            }
        }
    }

    public T dequeue() {
        moveValuesToOldestOnTopStack();
        if (stackWithOldestOnTop.isEmpty())
            throw new IllegalStateException();
        return stackWithOldestOnTop.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Peek: " + queue.peek());
        System.out.println("DeQueue: " + queue.dequeue());
        System.out.println("DeQueue: " + queue.dequeue());
        System.out.println("DeQueue: " + queue.dequeue());
        System.out.println("DeQueue: " + queue.dequeue());
        System.out.println("DeQueue: " + queue.dequeue());

        QueueWithTwoStacks<String> stringQueue = new QueueWithTwoStacks<>();
        stringQueue.enqueue("nishant");
        stringQueue.enqueue("singh");
        System.out.println("Peek: " + stringQueue.peek());
        System.out.println("DeQueue: " + stringQueue.dequeue());
        System.out.println("DeQueue: " + stringQueue.dequeue());
        System.out.println("DeQueue: " + stringQueue.dequeue());
    }
}
