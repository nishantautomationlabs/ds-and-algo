package com.nal.datastructures.trees;

import java.util.Arrays;

/**
 * Created by nishant on 25/02/20.
 */
public class SegmentTree {

    int[] segmentArr;
    int treeSize;
    int inputSize;

    public void createSegmentTree(int[] input) {
        inputSize = input.length;
        int height = (int) Math.ceil(Math.log(inputSize) / Math.log(2));   //height = logN
        treeSize = 2 * (int) Math.pow(2, height) - 1;    // 2 power(h +1) - 1;
        segmentArr = new int[treeSize];
        Arrays.fill(segmentArr, Integer.MAX_VALUE);
        createSegmentTree(input, 0, inputSize - 1, 0);
    }

    private void createSegmentTree(int[] input, int start, int end, int pos) {
        if (start == end) {
            segmentArr[pos] = input[start];
            return;
        }
        int mid = start + (end - start) / 2;
        createSegmentTree(input, start, mid, leftChildIndex(pos));
        createSegmentTree(input, mid + 1, end, rightChildIndex(pos));
        segmentArr[pos] = segmentArr[leftChildIndex(pos)] + segmentArr[rightChildIndex(pos)];
    }

    private int getSum(int queryStart, int queryEnd) {
        if (queryStart < 0 || queryEnd >= treeSize) {
            return -1;
        }
        return getSum(queryStart, queryEnd, 0, inputSize - 1, 0);
    }

    private int getSum(int queryStart, int queryEnd, int start, int end, int pos) {
        if (start >= queryStart && end <= queryEnd)
            return segmentArr[pos];
        if (end < queryStart || start > queryEnd)
            return 0;
        int mid = start + (end - start) / 2;
        return getSum(queryStart, queryEnd, start, mid, leftChildIndex(pos)) +
                getSum(queryStart, queryEnd, mid + 1, end, rightChildIndex(pos));
    }

    public void update(int newValue, int updatePos, int[] input) {
        if (updatePos < 0 || updatePos > input.length)
            throw new IllegalStateException();
        int diff = newValue - input[updatePos];
        input[updatePos] = newValue;
        update(0, input.length - 1, diff, updatePos, 0);
    }

    private void update(int start, int end, int diff, int updatePos, int pos) {
        if (start > updatePos || end < updatePos)
            return;
        segmentArr[pos] = segmentArr[pos] + diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            update(start, mid, diff, updatePos, leftChildIndex(pos));
            update(mid + 1, end, diff, updatePos, rightChildIndex(pos));

        }
    }

    public int leftChildIndex(int pos) {
        return 2 * pos + 1;
    }

    public int rightChildIndex(int pos) {
        return 2 * pos + 2;
    }

    public static void main(String[] args) {
        int[] input = {2, 5, 3, 1, 0, 3};
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.createSegmentTree(input);
        int sum = segmentTree.getSum(2, 4);
        System.out.println("Sum: " + sum);
        segmentTree.update(4, 4, input);
        sum = segmentTree.getSum(2, 4);
        System.out.println("Sum: " + sum);
    }
}
