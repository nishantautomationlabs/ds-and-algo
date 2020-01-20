package com.nal.datastructures.javainternal;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by nishant on 17/01/20.
 * Vector implements a dynamic array that means it can grow or shrink as required. Like an array, it contains components that can be accessed using an integer index
 * They are very similar to ArrayList but Vector is synchronised and have some legacy method which collection framework does not contain.
 * It extends AbstractList and implements List interfaces.
 *
 * Synchronization : Vector is synchronized, while arrayList is not synchronized
 * Performance: ArrayList is faster, since it is non-synchronized, while vector operations give slower performance since they are synchronized (thread-safe).
 * Data Growth: ArrayList and Vector both grow and shrink dynamically to maintain optimal use of storage – but the way they resize is different. ArrayList increments 50% of the current array size if the number of elements exceeds its capacity, while vector increments 100% – essentially doubling the current array size.
 * Traversal: Vector can use both Enumeration and Iterator for traversing over elements of vector while ArrayList can only use Iterator for traversing.
 */
public class JavaVector {

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add("Nishant");
        vector.add("Singh");
        vector.add(2);
        vector.add(5);
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        System.out.println("IsEmpty: " + vector.isEmpty());
        System.out.println("Contains Nishant: " + vector.contains("Nishant"));
        System.out.println("Index of Nishant: " + vector.indexOf("Nishant"));
        System.out.println("Last Index of 2: " + vector.lastIndexOf(2));
        System.out.println("Get element at index 3: " + vector.get(3));
        System.out.println("Get first element: " + vector.firstElement());
        System.out.println("Get last element: " + vector.lastElement());
        System.out.println(vector);

        vector.remove(0);
        vector.removeElement(2);
        vector.setSize(9);
        vector.ensureCapacity(20);

        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        System.out.println(vector);

        Vector<Integer> integerVector = new Vector<>(5, 10);
        integerVector.add(1);
        integerVector.add(2);
        integerVector.add(3);
        integerVector.add(4);
        integerVector.add(2, 5);
        Integer[] arr = new Integer[3];
        arr = integerVector.toArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(integerVector);
        integerVector.clear();


    }
}
