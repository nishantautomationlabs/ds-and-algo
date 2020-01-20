package com.nal.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 18/01/20.
 */
public class BSTLevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public BSTLevelOrderTraversal() {
        this.root = null;
    }

    //    O(h) where h is height of Binary Search Tree
    public void insert(int value) {
        root = insertInternal(root, value);
    }

    private Node insertInternal(Node root, int value) {
        if (root == null)
            root = new Node(value);
        else if (value <= root.data)
            root.left = insertInternal(root.left, value);
        else
            root.right = insertInternal(root.right, value);
        return root;
    }

    public void levelOrderTraversal() {
        System.out.println("Level Traversal of BST is: ");
        levelOrderTraversal(root);
        System.out.println();
    }

    private void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            System.out.print(node.data + " --> ");
        }
    }

    public static void main(String[] args) {
        BSTLevelOrderTraversal binarySearchTree = new BSTLevelOrderTraversal();
        binarySearchTree.insert(40);
        binarySearchTree.insert(60);
        binarySearchTree.insert(20);
        binarySearchTree.insert(30);
        binarySearchTree.insert(10);
        binarySearchTree.insert(50);
        binarySearchTree.insert(70);
        binarySearchTree.levelOrderTraversal();
    }
}
