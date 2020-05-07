package com.nal.datastructureimpl;

/**
 * Created by nishant on 11/01/20.
 */
public class QueueImplUsingArray {

    static class Queue {
        private int[] queue;
        private int size;
        private int capacity;
        private int front;
        private int rear;

        public Queue(int capacity) {
            this.capacity = capacity;
            queue = new int[capacity];
        }

        public void enQueue(int value) {
            if (!isFull()) {
                queue[rear] = value;
                rear = (rear + 1) % capacity;
                size++;
            } else
                System.out.println("Queue is full. Value not added");
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getFront()
        {
            return queue[front];
        }

        public int deQueue() {
            if (isEmpty())
                throw new IllegalStateException();
            int value = queue[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }

        public int getSize() {
            return size;
        }

        public void print() {
            System.out.print("Queue is ");
            if (isEmpty()) {
                System.out.println("Empty");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity]);
                if (i != size - 1)
                    System.out.print(" --> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println("Is Empty: " + queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.println("Is Full: " + queue.isFull());
        System.out.println("Size: " + queue.getSize());
        queue.print();
        System.out.println("Front: " + queue.getFront());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Size: " + queue.getSize());
        queue.print();
        queue.enQueue(6);
        queue.print();
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Is Empty: " + queue.isEmpty());
        queue.print();

    }


}
