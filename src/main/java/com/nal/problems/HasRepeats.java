package com.nal.problems;

import java.util.*;

/**
 * Created by nishant on 26/02/20.
 */
public class HasRepeats {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,2,2,2,2,2,2));
        List<Integer> repeats = new ArrayList<>(Arrays.asList(3,3,3,4));
        System.out.println(hasRepeats(numbers, repeats));

    }

    private static boolean hasRepeats(List<Integer> numbers, List<Integer> repeats) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(Integer num : numbers) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return dfs(freq, repeats, 0);
    }

    private static boolean dfs(HashMap<Integer, Integer> freq, List<Integer> repeats, int index) {
        if(index == repeats.size())
            return true;
        boolean result = false;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(entry.getValue() >= repeats.get(index)) {
                entry.setValue(entry.getValue() - repeats.get(index));
                result = result || dfs(freq, repeats, index + 1);
                entry.setValue(entry.getValue() + repeats.get(index));
            }
        }
        return result;
    }
}
