package com.nal.problems;

import java.util.HashMap;

/**
 * Created by nishant on 10/01/20.
 * Maximum distance between two occurrences of same element in array
 */
public class MaxDistance {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int maxDist = 0;
        int number = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i]))
                hashMap.put(arr[i], i);
            else {
                int index = hashMap.get(arr[i]);
                maxDist = i - index > maxDist ? i - index : maxDist;
                number = arr[i];
            }
        }
        System.out.println("Number is " + number + " Max distance is " + maxDist);
    }
}
