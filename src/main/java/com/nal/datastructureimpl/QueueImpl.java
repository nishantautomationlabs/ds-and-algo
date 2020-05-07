package com.nal.datastructureimpl;

/**
 * Created by nishant on 11/01/20.
 */
public class QueueImpl {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    //Time Complexity: O(1)
    public void enQueue(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null)
            head = node;
    }

    public int peek()
    {
        if(head == null)
            throw new IllegalStateException();
        return head.data;
    }

    //Time Complexity: O(1)
    public int deQueue() {
        if(head == null)
            throw new IllegalStateException();
        int value = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        return value;
    }

    public void print() {
        if(head == null) {
            System.out.println("Queue is Empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null)
                System.out.print(" --> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        System.out.println("Is Empty: " + queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println("Is Empty: " + queue.isEmpty());
        queue.print();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Remove from Queue: " + queue.deQueue());
        System.out.println("Remove from Queue: " + queue.deQueue());
        System.out.println("Remove from Queue: " + queue.deQueue());
        System.out.println("Remove from Queue: " + queue.deQueue());
        System.out.println("Remove from Queue: " + queue.deQueue());
        queue.print();
    }
}
