package com.nal.datastructures.javainternal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 12/01/20.
 */
public class JavaQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(null);
        System.out.println("Offer: " + queue.offer(6));
        System.out.println("Size: " + queue.size());
        printQueue(queue);
        System.out.println("Element: " + queue.element());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());
        printQueue(queue);
    }

    private static void printQueue(Queue<Integer> queue) {
        if(queue.size() == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        Iterator iterator = queue.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
            if(iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }


}
