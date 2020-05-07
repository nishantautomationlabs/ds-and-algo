package com.nal.trees;

/**
 * Created by nishant on 18/01/20.
 */
public class BinarySearchTreeDelete {

    TreeNode root;

    public BinarySearchTreeDelete() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal is: ");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " --> ");
        inorderTraversal(root.right);
    }

    public void deleteNode(int value) {
        this.root = deleteNode(root, value);
    }

    private TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            System.out.println("Node to delete not found");
            return null;
        }
        if (value < root.data)
            root.left = deleteNode(root.left, value);
        else if (value > root.data)
            root.right = deleteNode(root.right, value);
        else {
            if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                int min = minimumValue(root.right);
                root.data = min;
                root.right = deleteNode(root.right, min);
            }
        }
        return root;
    }

    private int minimumValue(TreeNode root) {
        int min = root.data;
        while (root != null) {
            min = root.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTreeDelete binarySearchTree = new BinarySearchTreeDelete();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
//        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(75);
        binarySearchTree.insert(85);
        binarySearchTree.inorderTraversal();
        binarySearchTree.deleteNode(70);
        binarySearchTree.inorderTraversal();
    }

}
