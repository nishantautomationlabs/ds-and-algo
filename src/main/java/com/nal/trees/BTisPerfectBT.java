package com.nal.trees;

/**
 * Created by nishant on 19/01/20.
 * A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.
 * A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 nodes.
 * Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
 * Now recursively traverse the tree and check for following two conditions.
 * Every internal node should have both children non-empty
 * All leaves are at depth ‘d’
 */
public class BTisPerfectBT {

    TreeNode root;

    public BTisPerfectBT() {
        this.root = null;
    }

    public boolean isPerfect() {
        return isPerfect(root, getDepth(root), 0);
    }

    private int getDepth(TreeNode root) {
        int depth = -1;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    private boolean isPerfect(TreeNode root, int treeDepth, int level) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            return level == treeDepth;
        } else if (root.left == null || root.right == null)
            return false;

        return isPerfect(root.left, treeDepth, level + 1) &&
                isPerfect(root.right, treeDepth, level + 1);
    }

    public static void main(String[] args) {
        BTisPerfectBT binaryTree = new BTisPerfectBT();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(40);
        binaryTree.root.left.right = new TreeNode(50);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(70);
        binaryTree.root.left.left.left = new TreeNode(80);
        binaryTree.root.left.left.right = new TreeNode(90);

        System.out.println("Is Perfect: " + binaryTree.isPerfect());
    }
}
