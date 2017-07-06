package com.liu.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 17-6-29.
 */
public class FourSum {
    /**
     * Given an array S of n integers, are there elements a; b; c, and d in S such that a+b+c+d = target?
     Find all unique quadruplets in the array which gives the sum of target.
     Note:
     Elements in a quadruplet (a; b; c; d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     the solution set must not contain duplicate quadruplets.
     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
     A solution set is:
     (-1, 0, 0, 1)
     (-2, -1, 1, 2)
     (-2, 0, 0, 2)
     */
    public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len<4){
            return result;
        }
        Arrays.sort(nums);

        return result;
    }
}
