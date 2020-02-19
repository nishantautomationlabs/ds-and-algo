package com.nal.datastructures.priorityqueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by nishant on 12/01/20.
 * PriorityQueue doesn’t permit null.
 * We can’t create PriorityQueue of Objects that are non-comparable
 * PriorityQueue are unbound queues.
 * The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied
 * for least value, the head is one of those elements — ties are broken arbitrarily.
 * The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
 * It inherits methods from AbstractQueue, AbstractCollection, Collection and Object class.
 * PriorityQueue is not thread safe, so java provides PriorityBlockingQueue class that implements the
 * BlockingQueue interface to use in java multithreading environment.
 * Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.
 */
public class JavaIntegerPriorityQueue {

    public static void main(String[] args) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        priorityQueue.add(50);
        priorityQueue.add(60);
        priorityQueue.add(30);
        priorityQueue.add(40);
        priorityQueue.add(40);
        priorityQueue.add(70);
        priorityQueue.add(10);

        System.out.println("Offer: " + priorityQueue.offer(90));
        System.out.println("Size: " + priorityQueue.size());
        printPriorityQueue(priorityQueue);
        System.out.println("Contains 90: " + priorityQueue.contains(90));
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Remove 60: " + priorityQueue.remove(60));
        System.out.println("Remove: " + priorityQueue.remove());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Size: " + priorityQueue.size());
        priorityQueue.clear();
        System.out.println("Is Empty: " + priorityQueue.isEmpty());
        printPriorityQueue(priorityQueue);
    }

    private static void printPriorityQueue(PriorityQueue<Integer> priorityQueue) {
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
            if(iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }
}
