package com.nal.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nishant on 26/01/20.
 * Median can be defined as the element in the data set which separates the higher half of the data sample from the lower half.
 * In other words we can get the median element as, when the input size is odd, we take the middle element of sorted data.
 * If the input size is even, we pick average of middle two elements in sorted stream.
 */
public class FindMedians {

    public static void main(String[] args) {
        int arr[] = {10, 15, 30, 4, 7, 20, 22};

        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        double median[] = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            addToHeap(arr[i], lowers, highers);
            rebalanceHeap(lowers, highers);
            median[i] = getMedian(lowers, highers);
        }
        Arrays.stream(arr).forEach(s -> System.out.print(s + " --> "));
        System.out.println();
        Arrays.stream(median).forEach(s -> System.out.print(s + " -> "));
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
        PriorityQueue<Integer> biggerHeap = lowers.size() < highers.size() ? highers : lowers;
        if(smallerHeap.size() == biggerHeap.size())
            return ((double)(smallerHeap.peek() + biggerHeap.peek()))/2;
        else
            return biggerHeap.peek();
    }

    private static void rebalanceHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
        PriorityQueue<Integer> biggerHeap = lowers.size() < highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addToHeap(int value, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || value < lowers.peek())
            lowers.add(value);
        else
            highers.add(value);
    }
}
