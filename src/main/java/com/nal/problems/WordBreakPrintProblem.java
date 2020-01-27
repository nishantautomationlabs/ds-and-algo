package com.nal.problems;

import java.util.*;

/**
 * Created by nishant on 25/01/20.
 * Recursion with memoization
 */
public class WordBreakPrintProblem {

    public static void main(String[] args) {
        String[] dictionary = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
//
//        String[] dictionary = {"c", "co", "o", "d", "e", "cod", "code"};
        Set<String> set = new HashSet<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String word : dictionary) {
            set.add(word);
        }
        WordBreakPrintProblem wordBreakProblem = new WordBreakPrintProblem();
        System.out.println("Using Recursion");
        List<String> result = wordBreakProblem.wordBreakUsingRecursionAndMemoization("ilikesamsung", set, hashMap);
        result.stream().forEach(s -> System.out.println(s));
        System.out.println("Using Queue");
        wordBreakProblem.wordBreakUsingQueue("ilikesamsung", set);
//        System.out.println(wordBreakProblem.wordBreakUsingRecursion("ilikesamsung", set, result));
//        System.out.println(wordBreakProblem.wordBreakUsingDynamicProgramming("ilikesamsung", set));
    }


    //Time Complexity O(N^2) where N is the number of characters in string
    private List<String> wordBreakUsingRecursionAndMemoization(String string, Set<String> set, HashMap<String, List<String>> memo) {

        if (string.equals("")) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("");
            return strings;
        } else if (memo.containsKey(string))
            return memo.get(string);
        System.out.println("Call::" + string);

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i))) {
                List<String> stringList = wordBreakUsingRecursionAndMemoization(string.substring(i), set, memo);
                for (String str : stringList) {
                    result.add(string.substring(0, i) + " " + str);
                }
            }
        }
        memo.put(string, result);
        return result;
    }

    class Option {
        int index;
        List<String> listOfWords;

        public Option(int index, List<String> listOfWords) {
            this.index = index;
            this.listOfWords = new ArrayList<>();
            this.listOfWords.addAll(listOfWords);
        }
    }

    private void wordBreakUsingQueue(String string, Set<String> set) {
        Queue<Option> optionQueue = new LinkedList<>();
        Option startOption = new Option(0, new ArrayList<>());
        optionQueue.add(startOption);

        while (!optionQueue.isEmpty()) {
            Option option = optionQueue.poll();
            if (option.index >= string.length()) {
                option.listOfWords.stream().forEach(s -> System.out.print(s + " "));
                System.out.println();
            }
            for (int i = option.index + 1; i <= string.length(); i++) {
                String word = string.substring(option.index, i);
                if (set.contains(word)) {
                    Option newOption = new Option(i, option.listOfWords);
                    newOption.listOfWords.add(word);
                    optionQueue.add(newOption);
                }
            }
        }
    }

    private boolean wordBreakUsingDynamicProgramming(String string, Set<String> set) {
        boolean[] dp = new boolean[string.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (dp[j] && set.contains(string.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[string.length()];
    }
}
