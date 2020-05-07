package com.nal.linkedlist;

/**
 * Created by nishant on 06/01/20.
 * Add 1 to a number represented as linked list
 * Input 1 --> 9 --> 9 --> 9
 * Output 2 --> 0 --> 0 --> 4
 */
public class AddOneToLinkedListNumber {

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
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(9);

        printLinkedList(head);
        int number = 1;
        head = addByReversingLinkedList(head, number);
//        head = addUsingRecursion(head, number);
//        head = addByTraversal(head, number);
        printLinkedList(head);
    }

    private static Node addByTraversal(Node head, int number) {
        Node prev = null;
        Node curr = head;

        while (curr.next != null) {
            if (curr.data != 9) {
                prev = curr;
            }
            curr = curr.next;
        }

        if (prev == null) {
            curr = head;
            while (curr != null) {
                curr.data = 0;
                curr = curr.next;
            }
            Node node = newNode(number);
            node.next = head;
            head = node;
            return head;
        }

        if (curr.data != 9)
            curr.data = curr.data + number;
        else {
            prev.data = prev.data + number;
            while (prev.next != null) {
                prev = prev.next;
                prev.data = 0;
            }
        }
        return head;
    }

    private static Node addUsingRecursion(Node head, int number) {
        int carry = addUsingRecursionInternal(head, number);
        if (carry > 0) {
            Node node = newNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }

    private static int addUsingRecursionInternal(Node head, int number) {
        if (head == null)
            return number;
        int value = head.data + addUsingRecursionInternal(head.next, number);
        head.data = value % 10;
        return value / 10;
    }

    private static Node addByReversingLinkedList(Node head, int number) {
        head = reverseLinkedList(head);
        printLinkedList(head);
        addNumberToLinkedList(head, number);
        printLinkedList(head);
        head = reverseLinkedList(head);
        return head;
    }

    private static void addNumberToLinkedList(Node head, int number) {
        if(head == null)
            throw new IllegalStateException();
        Node prev = null;
        while (head != null) {
            int value = head.data + number;
            head.data = value % 10;
            number = value / 10;
            if (number == 0)
                break;
            prev = head;
            head = head.next;
        }
        if (number > 0) {
            Node node = newNode(number);
            prev.next = node;
        }
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
