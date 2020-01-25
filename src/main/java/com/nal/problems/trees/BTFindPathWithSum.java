package com.nal.problems.trees;

import com.nal.datastructures.trees.TreeNode;

/**
 * Created by nishant on 20/01/20.
 */
public class BTFindPathWithSum {

    static int minimum;

    TreeNode root;

    public BTFindPathWithSum() {
        root = null;
    }

    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int subSum = sum - root.data;
        if (subSum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);
    }

    public boolean hasPathSumWithMinimumLength(int sum) {
        minimum = Integer.MAX_VALUE;
        return hasPathSumWithMinimumLength(root, sum, 0);
    }

    private boolean hasPathSumWithMinimumLength(TreeNode root, int sum, int level) {
        if (root == null)
            return false;
        int subSum = sum - root.data;
        if (subSum == 0 && root.left == null && root.right == null) {
            minimum = Math.min(minimum, level);
            return true;
        }

        boolean leftPathSum = hasPathSumWithMinimumLength(root.left, subSum, level + 1);
        boolean rightPathSum = hasPathSumWithMinimumLength(root.right, subSum, level + 1);
        return leftPathSum || rightPathSum;
    }

    public static void main(String[] args) {
        BTFindPathWithSum binaryTree = new BTFindPathWithSum();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(10);
        binaryTree.root.left.right = new TreeNode(50);
//        binaryTree.root.right.left = new Node(60);
//        binaryTree.root.right.right = new Node(70);
        System.out.println("Has Sum Path: " + binaryTree.hasPathSum(40));

        System.out.println("Has Sum Path: " + binaryTree.hasPathSumWithMinimumLength(40));
        System.out.println("Sum Path Length: " + binaryTree.minimum);

    }
}
