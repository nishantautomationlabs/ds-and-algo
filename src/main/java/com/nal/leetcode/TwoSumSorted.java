package com.nal.leetcode;

/**
 * Created by nishant on 30/01/20.
 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return null;

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int left = 0, right = numbers.length-1;
        while(left < right)
        {
            if(numbers[left] + numbers[right] == target)
            {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if(numbers[left] + numbers[right] < target)
                left++;
            else if(numbers[left] + numbers[right] > target)
                right--;
        }
        return res;
    }
}
