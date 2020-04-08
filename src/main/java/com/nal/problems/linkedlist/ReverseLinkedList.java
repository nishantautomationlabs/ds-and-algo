package com.nal.problems.linkedlist;

/**
 * Created by nishant on 06/01/20.
 */
public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }

    public static void main(String[] args) {

        Node head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);

        printLinkedList(head);
        head = reverseLinkedList(head);
        printLinkedList(head);

    }

    private static Node reverseLinkedList(Node head) {
        Node next;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private static void printLinkedList(Node head) {
        System.out.println("Linked list is ");
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" --> ");
            head = head.next;
        }
        System.out.println();
    }
}
