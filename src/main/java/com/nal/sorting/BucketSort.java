package com.nal.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nishant on 04/03/20.
 * Bucket sort is not a stable sorting algorithm.
 * Bucket sort is also not an in-place sorting algorithm
 * Bucket sort is only useful when the input is uniformly distributed over a range like coins, numbers 1 to 100 etc.
 * The time complexity of bucket sort in the O(N) in the best and average case and O(n^2) in the worst case
 * The space complexity of the bucket sort algorithm is O(n)
 */
public class BucketSort {

    public static void main(String[] args) {
        int arr[] = {80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};
        System.out.println("Input:" + Arrays.toString(arr));
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(arr);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int max = findMaxNumber(arr);
        int sqroot = (int) Math.sqrt(arr.length);
        List<List<Integer>> buckets = new ArrayList<>(sqroot);
        for (int i = 0; i < sqroot; i++)
            buckets.add(new ArrayList<>());

        for (int val : arr)
            buckets.get(hash(val, max, sqroot)).add(val);

        for(List<Integer> bucket : buckets)
            Collections.sort(bucket);

        int index = 0;
        for(List<Integer> bucket : buckets) {
            for (int val : bucket) {
                arr[index++] = val;
            }
        }
    }

    private int hash(int val, int max, int sqrt) {
        return (int) ((double) val / max * (sqrt - 1));
    }

    private int findMaxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
