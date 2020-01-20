package com.nal.problems.trees;

import com.nal.datastructures.trees.Node;

/**
 * Created by nishant on 18/01/20.
 * A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
 * Conversely, there is no node in a full binary tree, which has one child node.
 * Let T be a nonempty, full binary tree Then:
 * (a) If T has I internal nodes, the number of leaves is L = I + 1.
 * (b) If T has I internal nodes, the total number of nodes is N = 2I + 1.
 * (c) If T has a total of N nodes, the number of internal nodes is I = (N – 1)/2.
 * (d) If T has a total of N nodes, the number of leaves is L = (N + 1)/2.
 * (e) If T has L leaves, the total number of nodes is N = 2L – 1.
 * (f) If T has L leaves, the number of internal nodes is I = L – 1.
 */

public class BTisFullBinaryTree {

    Node root;

    public BTisFullBinaryTree() {
        this.root = null;
    }

    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }

    public boolean isFullBinaryTree(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.right != null && isFullBinaryTree(root.left) && isFullBinaryTree(root.right))
            return true;
        return false;
    }

    public static void main(String[] args) {
        BTisFullBinaryTree binaryTree = new BTisFullBinaryTree();
        binaryTree.root = new Node(50);
        binaryTree.root.left = new Node(30);
        binaryTree.root.left.left = new Node(20);
        binaryTree.root.left.right = new Node(40);
        binaryTree.root.right = new Node(70);
        binaryTree.root.right.left = new Node(60);
        binaryTree.root.right.right = new Node(80);
        System.out.println("isFullBinaryTree:" + binaryTree.isFullBinaryTree());
    }
}
