package com.nal.problems.trees;

import com.nal.datastructures.trees.TreeNode;

/**
 * Created by nishant on 23/01/20.
 */
public class SortedArrayToBST {

    TreeNode root;

    public SortedArrayToBST() {
        root = null;
    }

    public void createBSTFromArr(int[] arr) {
        root = createBSTFromArr(arr, 0, arr.length - 1);
    }

    public TreeNode createBSTFromArr(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createBSTFromArr(arr, start, mid - 1);
        node.right = createBSTFromArr(arr, mid + 1, end);
        return node;
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal of BST is: ");
        inorderTraversal(root);
        System.out.println();
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " --> ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        SortedArrayToBST arrayToBST = new SortedArrayToBST();
        arrayToBST.createBSTFromArr(arr);
        arrayToBST.inorderTraversal();


    }
}
