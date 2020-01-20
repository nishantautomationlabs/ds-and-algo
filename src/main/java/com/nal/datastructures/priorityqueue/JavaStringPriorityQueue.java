package com.nal.datastructures.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;

/**
 * Created by nishant on 12/01/20.
 * PriorityQueue doesn’t permit null.
 * We can’t create PriorityQueue of Objects that are non-comparable
 * PriorityQueue are unbound queues.
 * The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements — ties are broken arbitrarily.
 * The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
 * It inherits methods from AbstractQueue, AbstractCollection, Collection and Object class.
 * PriorityQueue is not thread safe, so java provides PriorityBlockingQueue class that implements the BlockingQueue interface to use in java multithreading environment.
 * Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.
 */
public class JavaStringPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Nishant");
        priorityQueue.add("Avik");
        priorityQueue.add("Ashish");
        priorityQueue.add("Arnab");
        priorityQueue.add("Peeyush");
        priorityQueue.add("Aishwarya");

        System.out.println("Offer: " + priorityQueue.offer("Venkatesh"));
        System.out.println("Size: " + priorityQueue.size());
        printPriorityQueue(priorityQueue);
        printPriorityQueueUsingSpliterator(priorityQueue);

        System.out.println("Contains Nishant: " + priorityQueue.contains("Nishant"));
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Remove 60: " + priorityQueue.remove("Venkatesh"));
        System.out.println("Remove: " + priorityQueue.remove());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Poll: " + priorityQueue.poll());
        priorityQueue.clear();
        System.out.println("Size: " + priorityQueue.size());
        System.out.println("Is Empty: " + priorityQueue.isEmpty());
        printPriorityQueue(priorityQueue);
    }

    private static void printPriorityQueue(PriorityQueue<String> priorityQueue) {
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
            if(iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }


//    The spliterator() method of PriorityQueue returns a Spliterator the same elements as PriorityQueue.
//    The returned Spliterator is late-binding and fail-fast Spliterator.
//    A late-binding Spliterator binds to the source of elements means PriorityQueue at the point of first traversal,
//    first split, or first query for estimated size, rather than at the time the Spliterator is created.
//    It can be used with Streams in Java 8. Also it can traverse elements individually and in bulk too.
//    Spliterator is better way to traverse over element because it provides more control on elements.
    private static void printPriorityQueueUsingSpliterator(PriorityQueue<String> priorityQueue) {
        System.out.println("Printing using Spliterator");
        Spliterator<String> spliterator = priorityQueue.spliterator();
        spliterator.forEachRemaining(s -> System.out.print(s + " --> "));
        System.out.println();
    }
}
