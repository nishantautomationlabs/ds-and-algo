package com.nal.algos.sorting;

import java.util.Arrays;

/**
 * Created by nishant on 01/03/20.
 *
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Input:" + Arrays.toString(arr));
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        System.out.println("Sorted:" + Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int maxNumber = getMaxNumber(arr);
        int maxLength = getLengthOfNum(maxNumber);
        int placeValue = 1;
        for (int i = 0; i < maxLength; i++) {
            countingSort(arr, placeValue);
            placeValue *= 10;
        }
    }

    private void countingSort(int[] arr, int placeValue) {
        int[] count = new int[10];
        for (int val : arr) {
            int num = getValueAtPlaceValue(val, placeValue);
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[getValueAtPlaceValue(arr[i], placeValue)] - 1] = arr[i];
            count[getValueAtPlaceValue(arr[i], placeValue)]--;
        }
        System.arraycopy(sorted, 0, arr, 0, sorted.length);
    }

    private int getValueAtPlaceValue(int val, int index) {
        return (val / index) % 10;
//        int result = 0;
//        while (index > 0) {
//            val = val / 10;
//            index--;
//        }
//        result = val % 10;
//        return result;
    }

    private int getLengthOfNum(int maxElement) {
        int length = 0;
        while (maxElement != 0) {
            maxElement = maxElement / 10;
            length++;
        }
        return length;
    }

    private int getMaxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
