package com.nal.problems;

import java.util.*;

/**
 * Created by nishant on 25/01/20.
 * Recursion with memoization
 */
public class WordBreakCheckProblem {

    public static void main(String[] args) {
        String[] dictionary = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};

//        String[] dictionary = {"c", "co", "cod", "code"};
        Set<String> set = new HashSet<>();
        HashMap<String, Boolean> hashMap = new HashMap<>();

        for (String word : dictionary) {
            set.add(word);
        }
        WordBreakCheckProblem wordBreakProblem = new WordBreakCheckProblem();
        System.out.println(wordBreakProblem.wordBreakUsingRecursion("ilikesamsung", set));
        System.out.println(wordBreakProblem.wordBreakUsingRecursionAndMemoization("ilikesamsung", set, hashMap));
        System.out.println(wordBreakProblem.wordBreakUsingDynamicProgramming("ilikesamsung", set));
    }


    //Time Complexity O(2^N) where N is the number of characters in string
    private boolean wordBreakUsingRecursion(String string, Set<String> set) {
        if (string.equals(""))
            return true;

        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i)) && wordBreakUsingRecursion(string.substring(i), set)) {
                System.out.println(string.substring(0, i));
                return true;
            }
        }
        return false;
    }

    //Time Complexity O(N^2) where N is the number of characters in string
    private boolean wordBreakUsingRecursionAndMemoization(String string, Set<String> set, HashMap<String, Boolean> hashMap) {
        if (string.equals(""))
            return true;
        else if (hashMap.containsKey(string))
            return hashMap.get(string);

        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i)) && wordBreakUsingRecursionAndMemoization(string.substring(i), set, hashMap)) {
                System.out.println(string.substring(0, i));
                hashMap.put(string, true);
                return true;
            }
        }
        hashMap.put(string, false);
        return false;
    }

    private boolean wordBreakUsingDynamicProgramming(String string, Set<String> set) {
        boolean[] dp = new boolean[string.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < string.length(); j++) { //for (int j = 0; j <= i; j++) {
                if (dp[j] && set.contains(string.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[string.length()];
    }
}
