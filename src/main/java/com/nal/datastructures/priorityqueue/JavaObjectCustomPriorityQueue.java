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
public class JavaObjectCustomPriorityQueue {

    static class Customer
    {
        private int customer_id;
        private String customer_name;

        public Customer(int customer_id, String customer_name) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
        }

        public int getCustomerID() {
            return customer_id;
        }

        public String getCustomerName() {
            return customer_name;
        }
    }

    public static void main(String[] args) {
//        Either the class should implement the Comparable interface and provide the implementation for the
//        compareTo() function or should provide a custom Comparator while creating the PriorityQueue

//        Comparator<Customer> comparator = (o1, o2) -> {
//            return o1.customer_id - o2.customer_id;
//        };
        Comparator<Customer> comparator = Comparator.comparingInt(o -> o.getCustomerID());

        PriorityQueue<Customer> priorityQueue = new PriorityQueue<>(comparator);
//        PriorityQueue<Customer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value.customer_id));
        priorityQueue.add(new Customer(1466, "Nishant"));
        priorityQueue.add(new Customer(546, "Avik"));
        priorityQueue.add(new Customer(2256, "Ashish"));
        priorityQueue.add(new Customer(356, "Arnab"));
        priorityQueue.add(new Customer(1755, "Peeyush"));
        priorityQueue.add(new Customer(2501, "Aishwarya"));
        System.out.println("Size: " + priorityQueue.size());
        printPriorityQueue(priorityQueue);
        System.out.println("Contains Nishant: " + priorityQueue.contains(new Customer(1466, "Nishant")));
        System.out.println("Peek: " + priorityQueue.peek().getCustomerID());
        System.out.println("Poll: " + priorityQueue.poll().getCustomerID());
        System.out.println("Remove: " + priorityQueue.remove().getCustomerID());
        System.out.println("Poll: " + priorityQueue.poll().getCustomerID());
        System.out.println("Poll: " + priorityQueue.poll().getCustomerID());
        System.out.println("Poll: " + priorityQueue.poll().getCustomerID());
        System.out.println("Poll: " + priorityQueue.poll().getCustomerID());
        priorityQueue.clear();
        System.out.println("Size: " + priorityQueue.size());
        System.out.println("Is Empty: " + priorityQueue.isEmpty());
        printPriorityQueue(priorityQueue);
    }

    private static void printPriorityQueue(PriorityQueue<Customer> priorityQueue) {
        Iterator iterator = priorityQueue.iterator();
        System.out.println("Queue contains: ");
        while (iterator.hasNext())
        {
            Customer customer = (Customer)iterator.next();
            System.out.println(customer.getCustomerID() + " " + customer.getCustomerName());
        }
        System.out.println();
    }
}
