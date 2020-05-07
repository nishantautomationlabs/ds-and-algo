package com.nal.trees;

/**
 * Created by nishant on 20/01/20.
 */
public class BTisSumBT {

    TreeNode root;

    public BTisSumBT() {
        root = null;
    }

    public boolean checkIfSumTree() {
        return checkIfSumTree(root);
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    private boolean checkIfSumTree(TreeNode root) {
        if (root == null || isLeaf(root))
            return true;

        int leftSum = 0, rightSum = 0;
        if (root.left != null)
            leftSum = isLeaf(root.left) ? root.left.data : root.left.data * 2;
        if (root.right != null)
            rightSum = isLeaf(root.right) ? root.right.data : root.right.data * 2;
        if (root.data != leftSum + rightSum)
            return false;

        return checkIfSumTree(root.left) && checkIfSumTree(root.right);
    }

    public static void main(String[] args) {
        BTisSumBT binaryTree = new BTisSumBT();
        binaryTree.root = new TreeNode(66);
        binaryTree.root.left = new TreeNode(26);
        binaryTree.root.right = new TreeNode(14);
        binaryTree.root.left.left = new TreeNode(10);
        binaryTree.root.left.right = new TreeNode(3);
        binaryTree.root.left.left.left = new TreeNode(6);
        binaryTree.root.left.left.right = new TreeNode(4);
        binaryTree.root.left.right.right = new TreeNode(3);

        System.out.println("Is Sum Tree: " + binaryTree.checkIfSumTree());

    }
}
