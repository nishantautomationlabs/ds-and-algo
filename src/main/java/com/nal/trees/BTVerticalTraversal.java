package com.nal.trees;

/**
 * Created by nishant on 23/01/20.
 */
public class BTVerticalTraversal {

    class MinMaxValue {
        int min;
        int max;
    }

    TreeNode root;

    public BTVerticalTraversal() {
        root = null;
    }

    public void verticalOrderTraversal() {
        System.out.println("Vertical Order Traversal of the Tree is ");
        verticalOrderTraversal(root);
    }

    private void verticalOrderTraversal(TreeNode root) {
        MinMaxValue value = new MinMaxValue();
        getMinMax(value, root, 0);
        for (int i = value.min; i <= value.max; i++) {
            printVerticalOrder(root, i, 0);
            System.out.println();
        }
    }

    private void printVerticalOrder(TreeNode root, int levelToPrint, int currLevel) {
        if (root == null)
            return;

        printVerticalOrder(root.left, levelToPrint, currLevel - 1);
        if (currLevel == levelToPrint) {
            System.out.print(root.data + " ");
        }
        printVerticalOrder(root.right, levelToPrint, currLevel + 1);
    }

    private void getMinMax(MinMaxValue value, TreeNode root, int level) {
        if (root == null)
            return;
        if (level < value.min)
            value.min = level;
        if (level > value.max)
            value.max = level;

        getMinMax(value, root.left, level - 1);
        getMinMax(value, root.right, level + 1);
    }


    public static void main(String[] args) {
        BTVerticalTraversal binaryTree = new BTVerticalTraversal();
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
