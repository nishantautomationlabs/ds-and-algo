package com.nal.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 25/02/20.
 */
public class IntervalSearchTree {

    public class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class IntervalTreeNode {
        Interval interval;
        int maxEnd;
        IntervalTreeNode left;
        IntervalTreeNode right;

        public IntervalTreeNode(int start, int end) {
            this.interval = new Interval(start, end);
        }
    }

    IntervalTreeNode root;

    public IntervalSearchTree() {
        this.root = null;
    }

    public void addNode(int start, int end) {
        if (end < start)
            throw new IllegalArgumentException("End should be greater than start");
        root = addNode(root, start, end);
    }

    private IntervalTreeNode addNode(IntervalTreeNode root, int start, int end) {
        if (root == null) {
            root = new IntervalTreeNode(start, end);
        } else if (start < root.interval.start) {
            root.left = addNode(root.left, start, end);
        } else {
            root.right = addNode(root.right, start, end);
        }
        root.maxEnd = Math.max(root.maxEnd, end);
        return root;
    }

    public IntervalTreeNode searchIntersectingNode(int start, int end) {
        return searchIntersectingNode(root, start, end);
    }

    private IntervalTreeNode searchIntersectingNode(IntervalTreeNode root, int start, int end) {
        if (root == null)
            return null;
        if ((root.interval.end > start && end > root.interval.start)) {
            return root;
        } else if (root.left == null || root.left.maxEnd < start) {
            return searchIntersectingNode(root.right, start, end);
        } else {
            return searchIntersectingNode(root.left, start, end);
        }
    }

    public List<IntervalTreeNode> searchAllIntersectingNode(int start, int end) {
        List<IntervalTreeNode> result = new ArrayList<>();
        searchAllIntersectingNode(root, start, end, result);
        return result;
    }

    private void searchAllIntersectingNode(IntervalTreeNode root, int start, int end, List<IntervalTreeNode> result) {
        if (root == null)
            return;
        if ((root.interval.end > start && end > root.interval.start)) {
            result.add(root);
        }
        if (root.left != null && root.left.maxEnd > start) {
            searchAllIntersectingNode(root.left, start, end, result);
        }
        if (root.right != null && root.interval.start < end) {
            searchAllIntersectingNode(root.right, start, end, result);
        }
    }

    public static void main(String[] args) {
        IntervalSearchTree intervalSearchTree = new IntervalSearchTree();
        intervalSearchTree.addNode(17, 19);
        intervalSearchTree.addNode(5, 8);
        intervalSearchTree.addNode(21, 24);
        intervalSearchTree.addNode(4, 8);
        intervalSearchTree.addNode(15, 18);
        intervalSearchTree.addNode(7, 10);
        intervalSearchTree.addNode(16, 22);
        IntervalTreeNode node = intervalSearchTree.searchIntersectingNode(21, 23);
        if (node != null) {
            System.out.println("Intersecting node is [" + node.interval.start + "," + node.interval.end + "]");
        } else
            System.out.println("No Intersecting node found");

        List<IntervalTreeNode> intervalTreeNodes = intervalSearchTree.searchAllIntersectingNode(21, 23);
        intervalTreeNodes.stream().forEach(s -> System.out.println("[" + s.interval.start + "," + s.interval.end + "]"));
        System.out.println("Wait");
    }
}
