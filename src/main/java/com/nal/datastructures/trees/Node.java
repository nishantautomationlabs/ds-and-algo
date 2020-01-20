package com.nal.datastructures.trees;

/**
 * Created by nishant on 18/01/20.
 */
public class Node {

    public int data;
    public Node left, right;

    public Node(int value) {
        this.data = value;
        left = right = null;
    }
}
