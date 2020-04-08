package com.nal.datastructures.impl;

/**
 * Created by nishant on 23/01/20.
 * Insert and search costs O(key_length), however the memory requirements of Trie is
 * O(ALPHABET_SIZE * key_length * N) where N is number of keys in Trie.
 * There are efficient representation of trie nodes (e.g. compressed trie, ternary search tree, etc.)
 * to minimize memory requirements of trie.
 */
public class TrieImpl {

    private static final int ALPHABET_SIZE = 26;

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    TrieNode root;

    public TrieImpl() {
        this.root = new TrieNode();
    }

    public void insert(String key) {
        insert(root, key);
    }

    public void insert(TrieNode root, String key) {
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (root.children[index] == null) {
                TrieNode newNode = new TrieNode();
                root.children[index] = newNode;
            }
            root = root.children[index];
        }
        root.isEndOfWord = true;
    }

    public boolean search(String key) {
        return search(root, key);
    }

    public boolean search(TrieNode root, String key) {
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (root.children[index] == null)
                return false;
            root = root.children[index];
        }
        return root.isEndOfWord;
    }

//    public void delete(String key) {
//        delete(root, key);
//    }
//
//    private void delete(TrieNode root, String key) {
//        TrieNode deleteBelow = null;
//
//        for(int i = 0; i < key.length(); i++)
//        {
//            int index = key.charAt(i) - 'a';
//            if(root.children[index] == null)
//                return;
//
//            root = root.children[index];
//        }
//    }


    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        trie.insert("cat");
        trie.insert("catlin");
        trie.insert("the");
        trie.insert("there");
        trie.insert("these");
        trie.insert("those");

        System.out.println("Search these: " + trie.search("these"));
        System.out.println("Search the: " + trie.search("the"));
        System.out.println("Search them: " + trie.search("them"));
        System.out.println("Search them: " + trie.search("thes"));
    }
}
