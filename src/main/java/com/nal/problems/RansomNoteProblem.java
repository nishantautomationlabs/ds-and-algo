package com.nal.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishant on 26/01/20.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 */
public class RansomNoteProblem {

    public static void main(String[] args) {
        String magazine[] = {"hello", "hello","hello","how", "are", "you"};
        String note[] = {"hello", "you", "hello"};
        System.out.println(canBuildNote(magazine, note));
    }

    private static boolean canBuildNote(String[] magazine, String[] note) {
        Map<String, Integer> frequencyMap = createFrequencyMap(magazine);
        return checkIfAllWordsExist(frequencyMap, note);
    }

    private static boolean checkIfAllWordsExist(Map<String, Integer> frequencyMap, String[] note) {
        for (String str : note) {
            if (frequencyMap.containsKey(str) && frequencyMap.get(str) > 0)
                frequencyMap.put(str, frequencyMap.get(str) - 1);
            else
                return false;
        }
        return true;
    }

    private static Map<String, Integer> createFrequencyMap(String[] magazine) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < magazine.length; i++) {
            if (!frequencyMap.containsKey(magazine[i]))
                frequencyMap.put(magazine[i], 0);
            frequencyMap.put(magazine[i], frequencyMap.get(magazine[i]) + 1);
        }
        return frequencyMap;
    }
}
