package com.nal.problems;

/**
 * Created by nishant on 07/01/20.
 * Add two numbers represented by linked lists
 * Input 9 --> 5 --> 3 --> 4
 * Input 7 --> 3 --> 2
 * Output 1--> 0--> 2--> 7--> 2
 * Time complexity O(max(m, n)) where m and n are number of nodes in first and second lists respectively.
 * Space complexity is O(max(m, n))
 */
public class AddTwoNumbersInLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        Node firstLL = new Node(9);
        firstLL.next = new Node(5);
        firstLL.next.next = new Node(3);
        firstLL.next.next.next = new Node(7);
        printLinkedList(firstLL);

        Node secondLL = new Node(7);
        secondLL.next = new Node(3);
        secondLL.next.next = new Node(5);
        printLinkedList(secondLL);

        firstLL = reverseLinkedList(firstLL);
        printLinkedList(firstLL);
        secondLL = reverseLinkedList(secondLL);
        printLinkedList(secondLL);

        Node ResultLL = addLinkedList(firstLL, secondLL);
        ResultLL = reverseLinkedList(ResultLL);
        printLinkedList(ResultLL);
    }

    private static Node addLinkedList(Node firstLL, Node secondLL) {
        int carry = 0;
        Node head3 = null;
        Node curr = null;
        while (firstLL != null || secondLL != null) {
            int value1 = firstLL == null ? 0 : firstLL.data;
            int value2 = secondLL == null ? 0 : secondLL.data;
            int sum = value1 + value2 + carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            if (head3 == null) {
                head3 = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
            if (firstLL != null)
                firstLL = firstLL.next;
            if (secondLL != null)
                secondLL = secondLL.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }
        return head3;
    }

    private static Node reverseLinkedList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print("--> ");
            head = head.next;
        }
        System.out.println();
    }
}
