package com.nal.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 18/01/20.
 * Time Complexity: O(n) where n is number of nodes in the binary tree
 * Space Complexity: O(n) where n is number of nodes in the binary tree
 */
public class BSTLevelOrderTraversal {

    TreeNode root;

    public BSTLevelOrderTraversal() {
        this.root = null;
    }

    //    O(h) where h is height of Binary Search Tree
    public void insert(int value) {
        root = insertInternal(root, value);
    }

    private TreeNode insertInternal(TreeNode root, int value) {
        if (root == null)
            root = new TreeNode(value);
        else if (value <= root.data)
            root.left = insertInternal(root.left, value);
        else
            root.right = insertInternal(root.right, value);
        return root;
    }

    public void levelOrderTraversal() {
        System.out.println("Level Traversal of BST is: ");
        levelOrderTraversal(root);
        System.out.println();
    }

    private void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            System.out.print(node.data + " --> ");
        }
    }

    public static void main(String[] args) {
        BSTLevelOrderTraversal binarySearchTree = new BSTLevelOrderTraversal();
        binarySearchTree.insert(40);
        binarySearchTree.insert(60);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30);
        binarySearchTree.insert(10);
        binarySearchTree.insert(50);
        binarySearchTree.insert(70);
        binarySearchTree.levelOrderTraversal();
    }
}
