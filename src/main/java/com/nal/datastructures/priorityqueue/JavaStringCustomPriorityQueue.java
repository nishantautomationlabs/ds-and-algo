package com.nal.datastructures.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

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
public class JavaStringCustomPriorityQueue {

    public static void main(String[] args) {
//        Comparator<String> stringLengthComparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

//        Comparator<String> stringLengthComparator3 = Comparator.comparingInt(String::length);

        Comparator<String> stringLengthComparator2 = (s1, s2) -> {
            if (s1.length() > s2.length())
                return 1;
            else if (s1.length() < s2.length())
                return -1;
            else
                return 0;
        };

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(stringLengthComparator2);
        priorityQueue.add("Nishant");
        priorityQueue.add("Avik");
        priorityQueue.add("Ashish");
        priorityQueue.add("Arnab");
        priorityQueue.add("Peeyush");
        priorityQueue.add("Aishwarya");

        System.out.println("Offer: " + priorityQueue.offer("Venkatesh"));
        System.out.println("Size: " + priorityQueue.size());
        printPriorityQueue(priorityQueue);
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
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }
}
