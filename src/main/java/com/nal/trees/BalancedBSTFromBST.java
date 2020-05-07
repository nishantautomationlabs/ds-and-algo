package com.nal.trees;

import java.util.ArrayList;

/**
 * Created by nishant on 23/01/20.
 */
public class BalancedBSTFromBST {

    TreeNode root;

    public BalancedBSTFromBST() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public void convertToBalancedBST(){
        root = convertToBalancedBST(root);
    }

    private TreeNode convertToBalancedBST(TreeNode root) {
        ArrayList<Integer> arrayList  = new ArrayList<>();
        addNodesToArray(arrayList, root);
        root = createTreeFromArray(arrayList, 0, arrayList.size()-1);
        return root;
    }

    private TreeNode createTreeFromArray(ArrayList<Integer> arrayList, int start, int end) {
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arrayList.get(mid));
        node.left = createTreeFromArray(arrayList, start, mid-1);
        node.right = createTreeFromArray(arrayList, mid+1, end);
        return node;
    }

    private void addNodesToArray(ArrayList<Integer> arrayList, TreeNode root) {
        if(root == null)
            return;
        addNodesToArray(arrayList, root.left);
        arrayList.add(root.data);
        addNodesToArray(arrayList, root.right);
    }

    public static void main(String[] args) {
        BalancedBSTFromBST binaryTree = new BalancedBSTFromBST();
        binaryTree.root = new TreeNode(10);
        binaryTree.root.left = new TreeNode(20);
        binaryTree.root.left.left = new TreeNode(30);
        binaryTree.root.left.left.left = new TreeNode(40);
        binaryTree.root.left.left.left.left = new TreeNode(50);
        binaryTree.root.left.left.left.left.left = new TreeNode(60);
        binaryTree.root.left.left.left.left.left.left = new TreeNode(70);
        binaryTree.convertToBalancedBST();
        System.out.println("Root node after balancing is " + binaryTree.root.data);
    }
}
