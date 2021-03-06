package com.nal.trees;

/**
 * Created by nishant on 18/01/20.
 */

public class BTisBSTCheck {

    TreeNode root;
    public BTisBSTCheck() {
        this.root = null;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;

        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }

    public boolean isBSTUsingNode() {
        return isBSTUsingNode(root, null, null);
    }

    public boolean isBSTUsingNode(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return true;
        if ((left != null && root.data <= left.data) || (right != null && root.data >= right.data))
            return false;

        return isBSTUsingNode(root.left, left, root) && isBSTUsingNode(root.right, root, right);
    }

    public boolean isBSTUsingInOrderTraversal() {
        return isBSTUsingInOrderTraversal(root, null);
    }

    public boolean isBSTUsingInOrderTraversal(TreeNode root, TreeNode prev) {
        if (root == null)
            return true;
        if (!isBSTUsingInOrderTraversal(root.left, prev))
            return false;
        if (prev != null && root.data <= prev.data)
            return false;
        prev = root;
        if (!isBSTUsingInOrderTraversal(root.right, prev))
            return false;
        return true;
    }

    public static void main(String[] args) {
        BTisBSTCheck binaryTree = new BTisBSTCheck();
        binaryTree.root = new TreeNode(50);
        binaryTree.root.left = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(20);
        binaryTree.root.left.right = new TreeNode(40);
        binaryTree.root.right = new TreeNode(70);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(80);
        System.out.println("isBST:" + binaryTree.isBST());
        System.out.println("isBST using Node:" + binaryTree.isBSTUsingNode());
        System.out.println("isBST using Inorder Traversal sorted nature :" + binaryTree.isBSTUsingInOrderTraversal());
    }
}
