package com.nal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 30/01/20.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    result.add(sol);

                    int leftValue = nums[left];
                    int rightValue = nums[right];
                    while (left < nums.length && nums[left] == leftValue)
                        left++;
                    while (right > left && nums[right] == rightValue)
                        right--;
                } else if (nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else if (nums[i] + nums[left] + nums[right] > 0)
                    right--;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
        return result;
    }
}
