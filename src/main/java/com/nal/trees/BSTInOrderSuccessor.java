package com.nal.trees;

/**
 * Created by nishant on 22/01/20.
 */
public class BSTInOrderSuccessor {

    TreeNode root;

    public BSTInOrderSuccessor() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return root;
        }
        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public TreeNode inorderSuccessor(int value) {
        return inorderSuccessor(root, value);
    }

    public TreeNode inorderPredecessor(int value) {
        return inorderPredecessor(root, value);
    }

    public TreeNode inorderPredecessor(TreeNode root, int value) {
        if (root == null)
            return null;
        TreeNode node = findNode(root, value);
        if (node == null) {
            System.out.println("Node with input value not found.");
            return null;
        }
        if(node.left != null)
            return findMin(node.left);
        else
            return findParentPredecessor(root, node);
    }

    private TreeNode findParentPredecessor(TreeNode root, TreeNode node) {
        TreeNode predecessor = null;
        while (root != null && root.data != node.data)
        {
            if(node.data < root.data)
                root = root.left;
            else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public TreeNode inorderSuccessor(TreeNode root, int value) {
        if (root == null)
            return null;
        TreeNode node = findNode(root, value);
        if (node == null) {
            System.out.println("Node with input value not found.");
            return null;
        }
        if (node.right != null)
            return findMin(node.right);
        else
            return findParentSuccessor(root, node);
    }

    private TreeNode findParentSuccessor(TreeNode root, TreeNode node) {
        TreeNode successor = null;
        while (root != null && root != node) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            } else
                root = root.right;
        }
        return successor;
    }

    private TreeNode findParentSuccessorRecursive(TreeNode root, TreeNode node, TreeNode successor) {
        if (root == null)
            return null;
        if (root.data == node.data)
            return successor;
        if (node.data < root.data) {
            successor = root;
            return findParentSuccessorRecursive(root.left, node, successor);
        } else
            return findParentSuccessorRecursive(root.right, node, successor);
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private TreeNode findNode(TreeNode root, int value) {
        if (root == null)
            return null;
        if (root.data == value)
            return root;
        if (value < root.data)
            return findNode(root.left, value);
        else
            return findNode(root.right, value);
    }

    public static void main(String[] args) {
        BSTInOrderSuccessor binaryTree = new BSTInOrderSuccessor();
        binaryTree.insert(60);
        binaryTree.insert(30);
        binaryTree.insert(10);
        binaryTree.insert(40);
        binaryTree.insert(35);
        binaryTree.insert(80);
        binaryTree.insert(70);
        binaryTree.insert(90);
        TreeNode successor = binaryTree.inorderSuccessor(35);
        TreeNode predecessor = binaryTree.inorderPredecessor(35);
        if (successor != null)
            System.out.println("InOrder successor value is " + successor.data);
        if (predecessor != null)
            System.out.println("InOrder predecessor value is " + predecessor.data);
    }
}
