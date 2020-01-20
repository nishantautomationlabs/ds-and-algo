package com.nal.problems.trees;

import com.nal.datastructures.trees.Node;

/**
 * Created by nishant on 19/01/20.
 */
public class BTMirror {

    Node root;

    public BTMirror() {
        this.root = null;
    }

    public void mirrorBT() {
        root = mirrorBT(root);
    }

    private Node mirrorBT(Node root) {
        if (root == null)
            return null;
        Node left = mirrorBT(root.left);
        Node right = mirrorBT(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal of Tree is:");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " --> ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BTMirror binaryTree = new BTMirror();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.right.left = new Node(60);
        binaryTree.root.right.right = new Node(70);
        binaryTree.root.left.left.left = new Node(80);
        binaryTree.root.left.left.right = new Node(90);
        binaryTree.inorderTraversal();
        binaryTree.mirrorBT();
        binaryTree.inorderTraversal();
    }
}
