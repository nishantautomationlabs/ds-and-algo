package com.nal.datastructures.trees;

import java.util.Stack;

/**
 * Created by nishant on 22/01/20.
 * Time Complexity: O(n)
 * Space Complexity: O(n)+(n)=O(n)
 */
public class BTZigzagTraversal {

    TreeNode root;

    public BTZigzagTraversal() {
        this.root = null;
    }

    public void zigzagTraversal() {
        System.out.println("Zigzag Traversal of Tree is ");
        zigzagTraversal(root);
        System.out.println();
    }

    private void zigzagTraversal(TreeNode root) {
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            if (leftToRight) {
                if(node.left != null)
                    nextLevel.push(node.left);
                if(node.right != null)
                    nextLevel.push(node.right);
            } else {
                if(node.right != null)
                    nextLevel.push(node.right);
                if(node.left != null)
                    nextLevel.push(node.left);
            }
            System.out.print(node.data + " --> ");

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        BTZigzagTraversal binaryTree = new BTZigzagTraversal();
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
        binaryTree.zigzagTraversal();
    }
}
