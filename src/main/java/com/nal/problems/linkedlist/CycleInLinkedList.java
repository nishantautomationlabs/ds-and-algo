package com.nal.problems.linkedlist;

/**
 * Created by nishant on 20/01/20.
 */
public class CycleInLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
        }
    }

    Node head;

    public CycleInLinkedList() {
        this.head = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null)
            head = newNode;
        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }

    public static void main(String[] args) {
        CycleInLinkedList linkedList = new CycleInLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.head.next.next.next.next.next.next = linkedList.head.next.next;
        System.out.println("Has Cycle: " + checkIfCycleExists(linkedList.head));
    }

    private static boolean checkIfCycleExists(Node head) {
        if (head == null || head.next == null)
            return false;
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
