package com.nal.problems;

/**
 * Created by nishant on 24/01/20.
 * Algorithm: Backtracking
 * Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
 */
public class StringPermutation {

    private void permute(String word, int start, int end) {
        if (start == end)
            System.out.println(word);

        for (int i = start; i <= end; i++) {
            word = swap(word, start, i);
            permute(word, start + 1, end);
            word = swap(word, start, i);
        }
    }

    private String swap(String word, int i, int j) {
        StringBuilder builder = new StringBuilder(word);
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);
        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "ABC";

        StringPermutation permutation = new StringPermutation();
        permutation.permute(input, 0, input.length() - 1);
    }
}
