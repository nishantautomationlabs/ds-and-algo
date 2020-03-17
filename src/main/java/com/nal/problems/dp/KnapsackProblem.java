package com.nal.problems.dp;

import java.util.HashMap;

/**
 * Created by nishant on 06/03/20.
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int price[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int capacity = 50;
        int itemCount = price.length;
        int maxPrice = knapsack(price, weight, capacity, itemCount);
        System.out.println(maxPrice);
        maxPrice = knapsackDP(price, weight, capacity);
        System.out.println(maxPrice);

    }

    private static int knapsackDP(int[] price, int[] weight, int capacity) {
        int[][] dp = new int[price.length + 1][capacity + 1];

        for (int i = 0; i <= price.length; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (w >= weight[i - 1]) {
                    dp[i][w] = Math.max(dp[i - 1][w], price[i -1 ] + dp[i - 1][w - weight[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[price.length][capacity];
    }

    private static int knapsack(int[] price, int[] weight, int capacity, int itemCount) {
        int result = 0;
        if (itemCount == 0 || capacity <= 0)
            return 0;

        if (weight[itemCount - 1] <= capacity) {
            int val1 = knapsack(price, weight, capacity, itemCount - 1);
            int val2 = price[itemCount - 1] + knapsack(price, weight, capacity - weight[itemCount - 1], itemCount - 1);
            result = Math.max(val1,
                    val2);
        } else {
            result = knapsack(price, weight, capacity, itemCount - 1);
        }
        return result;
    }
}
