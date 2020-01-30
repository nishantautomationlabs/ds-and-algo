package com.nal.leetcode;

import com.nal.datastructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 30/01/20.
 */
public class AllSumPath {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        List<Integer> res = new ArrayList<>();
        pathSumUtil(root, sum, res, result);
        return result;
    }

    public void pathSumUtil(TreeNode root, int sum, List<Integer> res, List<List<Integer>> result)
    {
        if(root == null)
            return;

        res.add(root.data);
        if(root.left == null && root.right == null && root.data == sum)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(res);
            result.add(temp);
        }
        pathSumUtil(root.left, sum - root.data, res, result);
        pathSumUtil(root.right, sum - root.data, res, result);
        res.remove(res.size()-1);
    }
}
