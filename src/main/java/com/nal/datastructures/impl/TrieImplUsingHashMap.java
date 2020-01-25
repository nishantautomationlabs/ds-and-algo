package com.nal.datastructures.impl;

import java.util.HashMap;

/**
 * Created by nishant on 23/01/20.
 */
public class TrieImplUsingHashMap {

    class TrieNode {
        boolean isEndOfWord;
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }

    TrieNode root;

    public TrieImplUsingHashMap() {
        this.root = new TrieNode();
    }

    public void insert(String key) {
        insert(root, key);
    }

    public void insert(TrieNode root, String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!root.children.containsKey(key.charAt(i))) {
                TrieNode newNode = new TrieNode();
                root.children.put(key.charAt(i), newNode);
            }
            root = root.children.get(key.charAt(i));
        }
        root.isEndOfWord = true;
    }

    public boolean search(String key) {
        return search(root, key);
    }

    public boolean search(TrieNode root, String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!root.children.containsKey(key.charAt(i)))
                return false;
            root = root.children.get(key.charAt(i));
        }
        return root.isEndOfWord;
    }

    public boolean startsWith(String key) {
        return startsWith(root, key);
    }

    public boolean startsWith(TrieNode root, String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!root.children.containsKey(key.charAt(i)))
                return false;
            root = root.children.get(key.charAt(i));
        }
        return true;
    }

    public boolean delete(String key) {
        return delete(root, key);
    }

    private boolean delete(TrieNode root, String key) {
        TrieNode deleteBelow = root;
        Character deleteChar = key.charAt(0);
        TrieNode parent = root;
        for(int i = 0; i < key.length(); i++)
        {
            if(!parent.children.containsKey(key.charAt(i))) {
                System.out.println("Key not present in Trie.");
                return false;
            }
            TrieNode child = parent.children.get(key.charAt(i));
            if(parent.children.size() > 1 || parent.isEndOfWord)
            {
                deleteBelow = parent;
                deleteChar = key.charAt(i);
            }
        parent = child;
        }
        if(!parent.isEndOfWord) {
            System.out.println("Key not present in Trie.");
            return false;
        }
        if(parent.children.isEmpty()) {
            deleteBelow.children.remove(deleteChar);
        } else
            parent.isEndOfWord = false;

        return true;
    }


    public static void main(String[] args) {
        TrieImplUsingHashMap trie = new TrieImplUsingHashMap();
        trie.insert("catfish");
        trie.insert("the");
        trie.insert("there");
        trie.insert("these");
        trie.insert("those");

        System.out.println("Starts With cat: " + trie.startsWith("cat"));
        System.out.println("Search these: " + trie.search("these"));
        System.out.println("Search the: " + trie.search("the"));
        System.out.println("Search them: " + trie.search("them"));
        System.out.println("Search them: " + trie.search("thes"));
        System.out.println("Delete catfish: " + trie.delete("catfish"));
    }
}
