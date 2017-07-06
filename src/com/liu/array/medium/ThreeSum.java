package com.liu.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 17-6-29.
 */
public class ThreeSum {
    /**
     * Given an array S of n integers, are there elements a; b; c in S such that a+ b+ c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * Elements in a triplet (a; b; c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * the solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4}.
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     * 前两个位置注意去重复选择
     * 折半查找第三个
     */
    public List<List<Integer>> threeSum(int[] nums){
        int target=0;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            for (int j = i+1; j < nums.length-1; j++) {
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                int c = target - nums[i] - nums[j];
                if(Arrays.binarySearch(nums,j+1,nums.length-1,c)>-1){
                    result.add(Arrays.asList(new Integer[]{nums[i],nums[j],c}));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,4}));
    }
}
