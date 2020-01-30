package com.nal.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nishant on 29/01/20.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return null;

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        Map<Integer, Integer> hashmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if(hashmap.containsKey(complement))
            {
                result[0] = hashmap.get(complement);
                result[1] = i;
                return result;
            }
            hashmap.put(nums[i], i);
        }
        return result;
    }
}
