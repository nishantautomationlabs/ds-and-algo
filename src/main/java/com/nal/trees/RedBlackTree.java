package com.nal.trees;

/**
 * Created by nishant on 26/02/20.
 */
public class RedBlackTree {

    public static final int RED = 1;
    public static final int BLACK = 0;

    class Node {
        int data;
        int color;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
            this.color = RED; //By default Red color
            this.left = TNULL;
            this.right = TNULL;
            this.parent = null;
        }

        public Node() {
        }
    }

    private Node root;
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();
        bst.insert(8);
        bst.insert(18);
        bst.insert(5);
        bst.insert(15);
        bst.insert(17);
        bst.insert(25);
        bst.insert(40);
        bst.insert(80);
//        bst.insert(40);
//        bst.insert(80);
        bst.prettyPrint();
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        Node parent = null;
        Node curr = root;

        while (curr != TNULL) {
            parent = curr;
            if (value < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        newNode.parent = parent;
        if (parent == null)
            root = newNode;
        else if (value < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;

        // if new node is a root node
        if (newNode.parent == null) {
            newNode.color = BLACK;
            return;
        }
        // if the grandparent is null
        if (newNode.parent.parent == null)
            return;

        rebalance(newNode);
    }

    private void rebalance(Node newNode) {
        //No changes required if parent of new node is BLACK
        if (isRoot(newNode) || newNode.parent.color == BLACK)
            return;

        //if parent is RED
        Node siblingOfParent = getSibling(newNode.parent);
        if (siblingOfParent != TNULL && siblingOfParent.color == RED) {
            siblingOfParent.color = BLACK;
            newNode.parent.color = BLACK;
            if (!isRoot(newNode.parent.parent))
                newNode.parent.parent.color = RED;
            rebalance(newNode.parent.parent);
        } else {
            if (newNode.parent.parent.right == newNode.parent) {
                //RL
                if(newNode.parent.left == newNode) {
                    newNode = newNode.parent;
                    rightRotate(newNode);
                }
                //RR
                newNode.parent.color = BLACK;
                newNode.parent.parent.color = RED;
                leftRotate(newNode.parent.parent);
            } else if (newNode.parent.parent.left == newNode.parent) {
                //LR
                if(newNode.parent.right == newNode) {
                    newNode = newNode.parent;
                    leftRotate(newNode);
                }
                //LL
                newNode.parent.color = BLACK;
                newNode.parent.parent.color = RED;
                rightRotate(newNode.parent.parent);
            }
            rebalance(newNode);
        }

    }

    private void rightRotate(Node node) {
        Node child = node.left;
        node.left = child.right;
        if (child.right != TNULL)
            child.right.parent = node;

        if (node.parent == null) {
            root = child;
        } else if (node.parent.right == node) {
            node.parent.right = child;
        } else {
            node.parent.left = child;
        }
        child.parent = node.parent;

        child.right = node;
        node.parent = child;
    }

    private void leftRotate(Node node) {
        Node child = node.right;
        node.right = child.left;
        if (child.left != TNULL)
            child.left.parent = node;

        if (node.parent == null) {
            root = child;
        } else if (node.parent.left == node) {
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }
        child.parent = node.parent;

        child.left = node;
        node.parent = child;
    }

    private boolean isRoot(Node node) {
        return node.parent == null;
    }

    private Node getSibling(Node node) {
        if (node == node.parent.left)
            return node.parent.right;
        else
            return node.parent.left;
    }

    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root == TNULL)
            return;
        System.out.print(indent);
        if (last) {
            System.out.print("R----");
            indent += "     ";
        } else {
            System.out.print("L----");
            indent += "|    ";
        }

        String color = root.color == RED ? "RED" : "BLACK";
        System.out.println(root.data + "(" + color + ")");
        printHelper(root.left, indent, false);
        printHelper(root.right, indent, true);
    }
}
