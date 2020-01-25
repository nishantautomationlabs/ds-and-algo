package com.nal.problems;

/**
 * Created by nishant on 23/01/20.
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String input = "This is a test String";
        System.out.println("Input: " + input);
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        input = reverseWordsInString.reverseString(input, 0, input.length() - 1);
        System.out.println("Reverse String: " + input);
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ' || i == input.length()-1) {
                int end = i == input.length()-1 ? i : i-1;
                input = reverseWordsInString.reverseString(input, start, end);
                start = i + 1;
            }
        }
        System.out.println("String with words reversed: " + input);
    }

    private String reverseString(String input, int start, int end) {
        while (start <= end) {
            input = swap(input, start, end);
            start++;
            end--;
        }
        return input;
    }

    private String swap(String input, int i, int j) {
        StringBuilder stringBuilder = new StringBuilder(input);
        char temp = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, stringBuilder.charAt(j));
        stringBuilder.setCharAt(j, temp);
        return stringBuilder.toString();
    }
}
