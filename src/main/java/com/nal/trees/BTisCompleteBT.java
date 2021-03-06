package com.nal.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 19/01/20.
 * A complete binary tree is a binary tree whose all levels except the last level are completely filled
 * and all the leaves in the last level are all to the left side.
 * The approach is to do a level order traversal starting from the root. In the traversal,
 * once a node is found which is NOT a Full Node, all the following nodes must be leaf nodes.
 * A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
 */
public class BTisCompleteBT {

    TreeNode root;

    public BTisCompleteBT() {
        this.root = null;
    }

    public boolean isCompleteUsingLevelOrderTraversal() {
        return isCompleteUsingLevelOrderTraversal(root);
    }

    private boolean isCompleteUsingLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean firstNonFullNodeEncountered = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                if (firstNonFullNodeEncountered)
                    return false;
                queue.add(node.left);
            } else
                firstNonFullNodeEncountered = true;
            if (node.right != null) {
                if (firstNonFullNodeEncountered)
                    return false;
                queue.add(node.right);
            } else
                firstNonFullNodeEncountered = true;
        }
        return true;
    }

    public boolean isCompleteUsingNodeIndex() {
        return isCompleteUsingNodeIndex(root, 0, getNodesCount(root));
    }

    private int getNodesCount(TreeNode root) {
        if (root == null)
            return 0;
        return getNodesCount(root.left) + getNodesCount(root.right) + 1;
    }

    private boolean isCompleteUsingNodeIndex(TreeNode root, int index, int nodesCount) {
        if (root == null)
            return true;
        if (index > nodesCount - 1)
            return false;
        return isCompleteUsingNodeIndex(root.left, 2 * index + 1, nodesCount) &&
                isCompleteUsingNodeIndex(root.right, 2 * index + 2, nodesCount);
    }

    public static void main(String[] args) {
        BTisCompleteBT binaryTree = new BTisCompleteBT();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(40);
        binaryTree.root.left.right = new TreeNode(50);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(70);
        binaryTree.root.left.right.left = new TreeNode(80);

        System.out.println("Count: " + binaryTree.getNodesCount(binaryTree.root));
        System.out.println("Is Complete Using Level Order Traversal: " + binaryTree.isCompleteUsingLevelOrderTraversal());
        System.out.println("Is Complete Using Nodes Index: " + binaryTree.isCompleteUsingNodeIndex());
    }
}
