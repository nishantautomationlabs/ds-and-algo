package com.nal.others;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Created by nishant on 14/01/20.
 */
public class SpliteratorDemo {

//    Sliterator has been introduced in Java 8.
//    It provides support for parallel processing of stream of elements for any collection.
//    It provides tryAdvance() method to iterate elements individually in different threads. It helps in parallel processing.
//    To iterate elements sequentially in a single Thread, use forEachRemaining() method.
//    The trySplit() method is used partition the spliterator, if it is possible.
//    It helps in combining the hasNext() and next() operations into one method.
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Stream<Integer> stream = arrayList.stream();
        Spliterator<Integer> spliterator = stream.spliterator();
        spliterator.forEachRemaining(s -> System.out.println(s));

        System.out.println("Estimate Size: " + spliterator.estimateSize());
        System.out.println("Characteristics: " + spliterator.characteristics());
    }
}
