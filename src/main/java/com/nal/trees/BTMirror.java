package com.nal.trees;

/**
 * Created by nishant on 19/01/20.
 */
public class BTMirror {

    TreeNode root;

    public BTMirror() {
        this.root = null;
    }

    public void mirrorBT() {
        root = mirrorBT(root);
    }

    private TreeNode mirrorBT(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorBT(root.left);
        TreeNode right = mirrorBT(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal of Tree is:");
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

    public static void main(String[] args) {
        BTMirror binaryTree = new BTMirror();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(40);
        binaryTree.root.left.right = new TreeNode(50);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(70);
        binaryTree.root.left.left.left = new TreeNode(80);
        binaryTree.root.left.left.right = new TreeNode(90);
        binaryTree.inorderTraversal();
        binaryTree.mirrorBT();
        binaryTree.inorderTraversal();
    }
}
