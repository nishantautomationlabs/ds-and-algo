package com.nal.datastructures.javainternal;

import java.util.*;

/**
 * Created by nishant on 17/01/20.
 * Set is an interface which extends Collection. It is an unordered collection of objects in which duplicate values cannot be stored.
 * Basically, Set is implemented by HashSet, LinkedHashSet or TreeSet (sorted representation).
 */
public class JavaSet {

    public static void main(String[] args) {

        System.out.println("Testing HashSet");
        //Order is not maintained, Duplicate values are not added
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Nishant");
        stringSet.add("Avik");
        stringSet.add("Ashish");
        stringSet.add("Peeyush");
        stringSet.add("Arnab");
//        stringSet.addAll(Arrays.asList(new String[] {"Aishwarya", "Arnab"}));
        stringSet.addAll(Arrays.asList("Aishwarya", "Arnab"));
        System.out.println(stringSet);
        stringSet.add("Avik");   // Duplicate values are not added
        System.out.println(stringSet);

        System.out.println("Testing TreeSet");
        //TreeSet keeps the values in a sorted order
        TreeSet<String> stringTreeSet = new TreeSet<>(stringSet);
        System.out.println(stringTreeSet);

        System.out.println("Testing LinkedHashSet");
        LinkedHashSet<String> stringLinkedHashSet = new LinkedHashSet<>();
        stringLinkedHashSet.add("Nishant");
        stringLinkedHashSet.add("Avik");
        stringLinkedHashSet.add("Ashish");
        stringLinkedHashSet.add("Peeyush");
        stringLinkedHashSet.add("Arnab");
        System.out.println(stringLinkedHashSet);
        stringLinkedHashSet.add("Avik");   // Duplicate values are not added
        System.out.println(stringLinkedHashSet);


        Set<Integer> integerSet1 = new HashSet<>();
        integerSet1.addAll(Arrays.asList(new Integer[] {1,2,3,4,5}));
        System.out.println(integerSet1);

        Set<Integer> integerSet2 = new HashSet<>();
        integerSet2.addAll(Arrays.asList(new Integer[] {4,5,6,7,8}));
        System.out.println(integerSet2);
        integerSet2.addAll(integerSet1);
        System.out.println("Union: " + integerSet2);

        integerSet2 = new HashSet<>();
        integerSet2.addAll(Arrays.asList(new Integer[] {4,5,6,7,8}));
        integerSet2.retainAll(integerSet1);
        System.out.println("Intersection: " + integerSet2);

        integerSet2 = new HashSet<>();
        integerSet2.addAll(Arrays.asList(new Integer[] {4,5,6,7,8}));
        integerSet2.removeAll(integerSet1);
        System.out.println("Difference: " + integerSet2);

    }
}
