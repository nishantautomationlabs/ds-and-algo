package com.nal.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by nishant on 24/01/20.
 */
public class StringSort {

    public String sort(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public String caseInsensitiveSort(String input) {
        Character[] chars = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        Arrays.sort(chars, Comparator.comparingInt(Character::toLowerCase));
//        Arrays.sort(chars, (c1, c2) -> Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2)));
//        Arrays.sort(chars, Comparator.comparingInt(c -> (Character.toLowerCase(c) - 'a')));
        StringBuilder builder = new StringBuilder(chars.length);
        for (Character c : chars) {
            builder.append(c.charValue());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "Nishant";
        StringSort stringSort = new StringSort();
        System.out.println("Sorted String is:" + stringSort.sort(input));
        System.out.println("Case Insensitive Sorted String is:" + stringSort.caseInsensitiveSort(input));
    }
}
