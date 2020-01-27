package com.nal.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishant on 26/01/20.
 * Given two strings in lowercase, the task is to make them anagram.
 * The only allowed operation is to remove a character from any string.
 * Find minimum number of characters to be deleted to make both the strings anagram?
 */
public class AnagramProblem {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";

        Map<Character, Integer> charFreqMap = createCharFrequencyMap(str1);
        removeFromCharFrequencyMap(charFreqMap, str2);
        int minimumCharToDelete = findMinimumCharToMakeAnagram(charFreqMap);
        System.out.println("Minimum Char to Delete is: " + minimumCharToDelete);
    }

    private static int findMinimumCharToMakeAnagram(Map<Character, Integer> charFreqMap) {
        int count = 0;
        for(Map.Entry entry : charFreqMap.entrySet())
        {
            count += Math.abs((int)entry.getValue());
        }
        return count;
    }

    private static void removeFromCharFrequencyMap(Map<Character, Integer> charFreqMap, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (!charFreqMap.containsKey(c))
                charFreqMap.put(c, 0);
            charFreqMap.put(c, charFreqMap.get(c) - 1);
        }
    }

    private static Map<Character, Integer> createCharFrequencyMap(String str1) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!characterIntegerMap.containsKey(c)) {
                characterIntegerMap.put(c, 0);
            }
            characterIntegerMap.put(c, characterIntegerMap.get(c) + 1);
        }
        return characterIntegerMap;
    }
}
