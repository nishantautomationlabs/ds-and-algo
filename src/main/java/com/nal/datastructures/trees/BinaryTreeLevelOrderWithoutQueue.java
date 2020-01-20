package com.nal.datastructures.trees;

/**
 * Created by nishant on 18/01/20.
 */

public class BinaryTreeLevelOrderWithoutQueue {

    Node root;
    public BinaryTreeLevelOrderWithoutQueue() {
        root = null;
    }

    public void levelOrderTraversal() {
        for (int i = 0; i <= getHeight(); i++) {
            printNodesAtLevel(root, i);
        }
        System.out.println();
    }

    private void printNodesAtLevel(Node root, int height) {
        if (root == null)
            return;
        if (height == 0)
            System.out.print(root.data + " --> ");
        else {
            printNodesAtLevel(root.left, height-1);
            printNodesAtLevel(root.right, height-1);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(Node root) {
        if (root == null)
            return -1;
        int lHeight = getHeight(root.left) + 1;
        int rHeight = getHeight(root.right) + 1;
        if (lHeight > rHeight)
            return lHeight;
        else
            return rHeight;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderWithoutQueue binaryTree = new BinaryTreeLevelOrderWithoutQueue();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.right.left = new Node(60);
        binaryTree.root.right.right = new Node(70);
        binaryTree.root.right.right.left = new Node(80);

        System.out.println("Height of the Binary Tree is: " + binaryTree.getHeight());
        binaryTree.levelOrderTraversal();
    }
}
