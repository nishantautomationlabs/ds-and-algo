package com.nal.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

/**
 * Created by nishant on 05/01/20.
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        int[] menu = {1, 2, 5, 13, 8, 3};
//        int[] menu = {1, 2, 5, 13, 5, 3};
        int money = 10;
        int[] choice = findChoiceUsingBinarySearch(menu, money);
        if (choice != null) {
            System.out.println(choice[0] + "-" + choice[1]);
            System.out.println(menu[choice[0] - 1] + "-" + menu[choice[1] - 1]);
        }

        choice = findChoiceUsingHashMap(menu, money);
        if (choice != null) {
            System.out.println(choice[0] + "-" + choice[1]);
            System.out.println(menu[choice[0] - 1] + "-" + menu[choice[1] - 1]);
        }
    }

    private static int[] findChoiceUsingHashMap(int[] menu, int money) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < menu.length; i++) {
            int complement = money - menu[i];
            if (map.containsKey(complement)) {
                int[] indices = new int[]{i + 1, map.get(complement) + 1};
                return indices;
            }
            map.put(menu[i], i);
        }
        return null;
    }

    private static int[] findChoiceUsingBinarySearch(int[] menu, int money) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if (location > 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }
        return null;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1) + 1;
        int index2 = indexOf(menu, value2, index1) + 1;
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    private static int indexOf(int[] menu, int value, int excludeIndex) {
        for (int i = 0; i < menu.length; i++) {
            if (value == menu[i] && i != excludeIndex)
                return i;
        }
        return -1;
    }
}
