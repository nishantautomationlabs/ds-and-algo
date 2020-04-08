package com.nal.problems;

/**
 * Created by nishant on 06/04/20.
 */
public class ContactsUsingTrie {

    private static final int ALPHABET_SIZE = 26;

    class TrieNode {
        boolean isEndOfWord;
        int count;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        public TrieNode() {
            isEndOfWord = false;
            count = 0;
        }
    }

    TrieNode root;

    public ContactsUsingTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        curr.count++;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr.children[index].count++;
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public int countWithPrefix(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.count;
    }

    public static void main(String[] args) {
        ContactsUsingTrie contacts = new ContactsUsingTrie();
        contacts.insert("cat");
        contacts.insert("catlin");
        contacts.insert("the");
        contacts.insert("there");
        contacts.insert("these");
        contacts.insert("those");
        System.out.println(contacts.countWithPrefix(""));
        System.out.println(contacts.countWithPrefix("cat"));
        System.out.println(contacts.countWithPrefix("th"));
        System.out.println(contacts.countWithPrefix("the"));
    }
}
