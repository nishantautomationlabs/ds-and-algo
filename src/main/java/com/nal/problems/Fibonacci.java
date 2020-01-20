package com.nal.problems;

import java.util.Arrays;

/**
 * Created by nishant on 07/01/20.
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
//        int fibValue = getFibValueUsingRecursion(n);
        int fibValue = getFibValueUsingMemoization(n);
        System.out.println(fibValue);
    }

    private static int getFibValueUsingRecursion(int n) {
        if(n <= 1)
            return n;
        return getFibValueUsingRecursion(n-1) + getFibValueUsingRecursion(n-2);
    }

    private static int getFibValueUsingMemoization(int n) {
        int[] fibMemo = new int[50];
        Arrays.fill(fibMemo, -1);
        fibMemo[0] = 0;
        fibMemo[1] = 1;
        return fibonacciUsingMemoization(n, fibMemo);
    }

    private static int fibonacciUsingMemoization(int n, int[] fibMemo) {
        if (fibMemo[n] == -1) {
            fibMemo[n] = fibonacciUsingMemoization(n - 1, fibMemo) + fibonacciUsingMemoization(n - 2, fibMemo);
        }
        return fibMemo[n];
    }
}
