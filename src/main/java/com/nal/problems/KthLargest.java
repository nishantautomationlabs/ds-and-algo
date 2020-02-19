package com.nal.problems;

import com.nal.leetcode.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by nishant on 16/02/20.
 */
public class KthLargest {

    public static void main(String[] args) {
        int[] input = {3, 2, 1, 4, 6, 5, 7};
        KthLargest sol = new KthLargest();
        int res = sol.kthLargestElementUsingQuickPartition(input, 2);
        System.out.println("kth largest element is: " + res);
    }


    //O(NLogN)
    private int kthLargestElementUsingSorting(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //O(NlogK)
    private int kthLargestElementUsingHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.isEmpty() || nums[i] > minHeap.peek()) {
                minHeap.add(nums[i]);
                if (minHeap.size() > k) {
                    minHeap.remove();
                }
            }
        }
        return minHeap.peek();
    }

    //O(N) time complexity
    private int kthLargestElementUsingQuickPartition(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int pIndex = 0;
        while (pIndex != k - 1) {
            pIndex = partition(nums, left, right);
            if (pIndex == k - 1) {
                return nums[pIndex];
            }
            if (pIndex < k - 1) {
                left = pIndex + 1;
            } else {
                right = pIndex - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, j++);
            }
        }
        swap(nums, j, right);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
