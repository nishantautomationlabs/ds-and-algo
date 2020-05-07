package com.nal.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by nishant on 22/01/20.
 * Time Complexity: O(n) where n is number of nodes in the binary tree.
 */
public class BTReverseLevelTraversal {

    TreeNode root;

    public BTReverseLevelTraversal() {
        root = null;
    }

    private void reverseLevelOrderTraversal() {
        System.out.println("Reverse Level Order is: ");
        reverseLevelOrderTraversal(root);
        System.out.println();
    }

    private void reverseLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
            stack.add(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " --> ");
        }
    }


    public static void main(String[] args) {
        BTReverseLevelTraversal binaryTree = new BTReverseLevelTraversal();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.right = new TreeNode(30);
        binaryTree.root.left.left = new TreeNode(40);
        binaryTree.root.left.right = new TreeNode(50);
        binaryTree.root.right.left = new TreeNode(60);
        binaryTree.root.right.right = new TreeNode(70);
        binaryTree.root.left.left.left = new TreeNode(80);
        binaryTree.root.left.left.right = new TreeNode(90);
        binaryTree.root.left.right.left = new TreeNode(100);
        binaryTree.root.left.right.right = new TreeNode(110);
        binaryTree.root.right.left.left = new TreeNode(120);
        binaryTree.root.right.left.right = new TreeNode(130);
        binaryTree.root.right.right.left = new TreeNode(140);
        binaryTree.root.right.right.right = new TreeNode(150);
        binaryTree.reverseLevelOrderTraversal();
    }
}
