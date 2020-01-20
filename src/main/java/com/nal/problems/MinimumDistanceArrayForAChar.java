package com.nal.problems;

import java.util.Arrays;

/**
 * Created by nishant on 16/01/20.
 * Shortest distance to every other character from given character
 * input nishant
 * output [0, 1, 2, 2, 1, 0, 1]
 */
public class MinimumDistanceArrayForAChar {

    public static void main(String[] args) {
        String input = "nishant";
        char character = 'n';
        int[] arr = new int[input.length()];

        setForwardCount(input, character, arr);
        System.out.println(Arrays.toString(arr));
        updateReverseCount(input, character, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void setForwardCount(String input, char character, int[] arr) {
        int counter = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == character) {
                counter = 0;
            } else if (counter != Integer.MAX_VALUE)
                counter++;

            arr[i] = counter;
        }
    }

    private static void updateReverseCount(String input, char character, int[] arr) {
        int counter = Integer.MAX_VALUE;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == character) {
                counter = 0;
            } else if (counter != Integer.MAX_VALUE)
                counter++;

            if(arr[i] > counter)
                arr[i] = counter;
        }
    }
}
