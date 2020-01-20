package com.nal.datastructures.javainternal;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by nishant on 10/01/20.
 */
public class JavaLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(6);
        linkedList.addFirst(7);
        linkedList.addFirst(8);
        linkedList.addFirst(9);
        linkedList.addFirst(null);
        linkedList.addLast(4);
        System.out.println(linkedList.offerFirst(10));
        System.out.println(linkedList.offerLast(5));
        printLinkedList(linkedList);
        System.out.println("Size: " + linkedList.size());
        System.out.println("Get First: " + linkedList.getFirst());
        System.out.println("Get Last: " + linkedList.getLast());
        System.out.println("Peek: " + linkedList.peek());

        System.out.println("Poll First: " + linkedList.pollFirst());
        System.out.println("Poll Last: " + linkedList.pollLast());
        printLinkedList(linkedList);
        System.out.println("Pop: " + linkedList.pop());
        System.out.println("Remove: " + linkedList.remove());
        System.out.println("Remove First: " + linkedList.removeFirst());
        System.out.println("Remove Last: " + linkedList.removeLast());
        printLinkedList(linkedList);
        linkedList.clear();
        System.out.println("Size: " + linkedList.size());
        printLinkedList(linkedList);
    }

    private static void printLinkedList(LinkedList<Integer> linkedList) {
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                System.out.print(" --> ");
        }
        System.out.println();
    }
}
