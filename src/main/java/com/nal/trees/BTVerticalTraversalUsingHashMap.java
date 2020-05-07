package com.nal.trees;

import java.util.*;

/**
 * Created by nishant on 23/01/20.
 */
public class BTVerticalTraversalUsingHashMap {

    TreeNode root;

    public BTVerticalTraversalUsingHashMap() {
        root = null;
    }

    public void verticalOrderTraversal() {
        System.out.println("Vertical Order Traversal of the Tree is ");
        verticalOrderTraversal(root);
    }

    private void verticalOrderTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> verticalLevelMap = new TreeMap<>();
        createVerticalLevelMap(root, verticalLevelMap, 0);
        for (Map.Entry<Integer, List<Integer>> entry : verticalLevelMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private void createVerticalLevelMap(TreeNode root, TreeMap<Integer, List<Integer>> verticalLevelMap, int level) {
        if (root == null)
            return;
        if (root.left != null)
            createVerticalLevelMap(root.left, verticalLevelMap, level - 1);

        if (verticalLevelMap.containsKey(level)) {
            verticalLevelMap.get(level).add(root.data);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.data);
            verticalLevelMap.put(level, arrayList);
        }

        if (root.right != null)
            createVerticalLevelMap(root.right, verticalLevelMap, level + 1);
    }

    public static void main(String[] args) {
        BTVerticalTraversalUsingHashMap binaryTree = new BTVerticalTraversalUsingHashMap();
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
        binaryTree.verticalOrderTraversal();
    }
}
