package com.nal.trees;

/**
 * Created by nishant on 18/01/20.
 Time Complexity: O(n^2) in worst case.
 Space Complexity: O(n) in worst case
 */

public class BinaryTreeLevelOrderWithoutQueue {

    TreeNode root;
    
    public BinaryTreeLevelOrderWithoutQueue() {
        root = null;
    }

    public void levelOrderTraversal() {
        for (int i = 0; i <= getHeight(); i++) {
            printNodesAtLevel(root, i);
        }
        System.out.println();
    }

    private void printNodesAtLevel(TreeNode root, int height) {
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

    public int getHeight(TreeNode root) {
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
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(40);
        binaryTree.root.left.right = new TreeNode(50);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(70);
        binaryTree.root.right.right.left = new TreeNode(80);

        System.out.println("Height of the Binary Tree is: " + binaryTree.getHeight());
        binaryTree.levelOrderTraversal();
    }
}
