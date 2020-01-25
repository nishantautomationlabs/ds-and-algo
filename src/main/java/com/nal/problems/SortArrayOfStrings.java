package com.nal.problems;

/**
 * Created by nishant on 24/01/20.
 * Sort the words in lexicographical order
 */
public class SortArrayOfStrings {

    private static final int ALPHABET_SIZE = 26;

    class TrieNode {
        int indexOfString;
        TrieNode[] children;

        public TrieNode() {
            indexOfString = -1;
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    TrieNode root;

    public SortArrayOfStrings() {
        root = new TrieNode();
    }

    public void insert(String key, int index) {
        insert(root, key, index);
    }

    private void insert(TrieNode root, String key, int index) {

        for (int i = 0; i < key.length(); i++) {
            int charIndex = key.charAt(i) - 'a';
            if (root.children[charIndex] == null) {
                TrieNode newNode = new TrieNode();
                root.children[charIndex] = newNode;
            }
            root = root.children[charIndex];
        }
        root.indexOfString = index;
    }

    public void printInSortedOrder(String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            for (int j = i + 1; j < stringArr.length; j++) {
                if (stringArr[i].compareTo(stringArr[j]) > 1) {
                    String temp = stringArr[i];
                    stringArr[i] = stringArr[j];
                    stringArr[j] = temp;
                }
            }
        }
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(stringArr[i]);
        }
    }

    public void printInSortedOrderUsingTrie(String[] stringArr) {
        printInSortedOrderUsingTrie(root, stringArr);
    }

    private void printInSortedOrderUsingTrie(TrieNode root, String[] stringArr) {
        if (root == null)
            return;
        if (root.indexOfString != -1)
            System.out.println(stringArr[root.indexOfString]);

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            printInSortedOrderUsingTrie(root.children[i], stringArr);
        }
    }

    public static void main(String[] args) {
        String[] stringArr = {"the", "these", "cat", "catfish", "them", "those" };

        SortArrayOfStrings trie = new SortArrayOfStrings();

        for (int i = 0; i < stringArr.length; i++) {
            trie.insert(stringArr[i], i);
        }

        System.out.println("Using Trie");
        trie.printInSortedOrderUsingTrie(stringArr);

        System.out.println("Without Trie");
        trie.printInSortedOrder(stringArr);
    }

}
