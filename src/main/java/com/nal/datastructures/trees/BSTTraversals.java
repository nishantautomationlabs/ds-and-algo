package com.nal.datastructures.trees;

/**
 * Created by nishant on 18/01/20.
 * Binary Search Tree, is a node-based binary tree data structure which has the following properties:
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 * Time Complexity: The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree.
 * The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).
 * Inorder traversal of BST always produces sorted output.
 */
public class BSTTraversals {

    TreeNode root;

    public BSTTraversals() {
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

    public void inorderTraversal() {
        System.out.println("Inorder Traversal of BST is: ");
        inorderTraversal(root);
        System.out.println();
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " --> ");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal() {
        System.out.println("Pre-Order Traversal of BST is: ");
        preOrderTraversal(root);
        System.out.println();
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " --> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal() {
        System.out.println("Post-Order Traversal of BST is: ");
        postOrderTraversal(root);
        System.out.println();
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " --> ");
    }

    public static void main(String[] args) {
        BSTTraversals binarySearchTree = new BSTTraversals();
        binarySearchTree.insert(10);
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(70);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.inorderTraversal();
        binarySearchTree.preOrderTraversal();
        binarySearchTree.postOrderTraversal();
        System.out.println("Done");
    }
}
