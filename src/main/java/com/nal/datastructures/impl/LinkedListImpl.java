package com.nal.datastructures.impl;

/**
 * Created by nishant on 10/01/20.
 */
public class LinkedListImpl {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    //Time Complexity: O(N)
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = node;
        }
    }

    //Time Complexity: O(1)
    public void insertAtFront(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void insertAfter(int existingNodeValue, int value) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.data == existingNodeValue) {
                Node newNode = new Node(value);
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Value " + existingNodeValue + " not found");
        }
    }

    //Time Complexity: O(N)
    public void deleteLastNode() {
        Node secondLast = head;
        if (secondLast == null) {
            System.out.println("Linked List is Empty. Nothing to delete.");
            return;
        } else if (head.next == null) {
            head = null;
            return;
        }
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    //Time Complexity: O(1)
    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("Linked List is Empty. Nothing to delete.");
            return;
        }
        head = head.next;
    }

    public void deleteNodeAtIndex(int index) {
        if (head == null) {
            System.out.println("Linked List is Empty. Nothing to delete from.");
            return;
        }
        if (index == 0) {
            System.out.println("Deleting Node at index 0");
            head = head.next;
            return;
        }

        int current = 0;
        Node curr = head;
        Node prev = null;
        while (curr != null) {

            if (current == index) {
                System.out.println("Deleting Node at index " + current);
                prev.next = curr.next;
                break;
            }
            current++;
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Element to delete not found");
        }
    }

    public void deleteNodeWithValue(int value) {
        if (head == null) {
            System.out.println("Linked List is Empty. Nothing to delete from.");
            return;
        }
        if (head.data == value) {
            System.out.println("Deleting Node with Value " + value);
            head = head.next;
            return;
        }

        Node curr = head.next;
        Node prev = head;
        while (curr != null) {

            if (curr.data == value) {
                System.out.println("Deleting Node with Value " + value);
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Element with value " + value + " not found");
        }
    }


    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("Linked List is Empty. Nothing to print.");
            return;
        }
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" --> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtFront(5);
        linkedList.insertAtFront(7);
        linkedList.insertAtFront(8);
        printLinkedList(linkedList.head);
        linkedList.insertAfter(7, 6);
        linkedList.insertAfter(3, 4);
        printLinkedList(linkedList.head);
        linkedList.deleteNodeAtIndex(0);
        printLinkedList(linkedList.head);
        linkedList.deleteNodeWithValue(2);
        printLinkedList(linkedList.head);
        System.out.println("Delete last node");
        linkedList.deleteLastNode();
        printLinkedList(linkedList.head);
        System.out.println("Delete first node");
        linkedList.deleteFirstNode();
        printLinkedList(linkedList.head);
    }


}
