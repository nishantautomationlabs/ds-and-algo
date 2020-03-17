package com.nal.problems.trees;

import com.nal.datastructures.trees.TreeNode;

import java.util.Stack;

/**
 * Created by nishant on 09/03/20.
 */
public class ConvertBinaryTreeToSortedDoublyLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        TreeNode head = convertBTToLL(root);
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.right;
        }
    }

    private static TreeNode convertBTToLL(TreeNode root) {
        if (root == null)
            return null;

        TreeNode head = null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev == null) {
                    head = curr;
                    curr.left = null;
                } else {
                    prev.right = curr;
                    curr.left = prev;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        prev.right = null;
        return head;
    }
}
