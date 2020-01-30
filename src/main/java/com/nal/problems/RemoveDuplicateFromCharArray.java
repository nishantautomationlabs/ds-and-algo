package com.nal.problems;

/**
 * Created by nishant on 28/01/20.
 */
public class RemoveDuplicateFromCharArray {

    public static void main(String[] args) {
        char[] charArray = {'a', 'a', 'a', 'a', 'b', 'b', 'c', 'd'};
        RemoveDuplicateFromCharArray charUtil = new RemoveDuplicateFromCharArray();

        System.out.print("Input character array is: ");
        charUtil.printCharArray(charArray, charArray.length);

        int size = charUtil.removeDuplicateFromSortedCharArray(charArray);

        System.out.print("Characters after removing duplicates are: ");
        charUtil.printCharArray(charArray, size);

    }

    private void printCharArray(char[] charArray, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
    }

    private int removeDuplicateFromSortedCharArray(char[] charArray) {
        if (charArray.length <= 1)
            return charArray.length;
        int i = 0;
        for (int j = 1; j < charArray.length; j++) {
            if (charArray[i] != charArray[j]) {
                i++;
                charArray[i] = charArray[j];
            }
        }
        return i + 1;
    }

}
