package com.nal.trees;

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

    TreeNode root;

    public BTisFullBinaryTree() {
        this.root = null;
    }

    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }

    public boolean isFullBinaryTree(TreeNode root) {
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
        binaryTree.root = new TreeNode(50);
        binaryTree.root.left = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(20);
        binaryTree.root.left.right = new TreeNode(40);
        binaryTree.root.right = new TreeNode(70);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(80);
        System.out.println("isFullBinaryTree:" + binaryTree.isFullBinaryTree());
    }
}
