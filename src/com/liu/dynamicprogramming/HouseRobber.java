package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-9.
 */
public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is t
     * hat adjacent houses have security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        else if(len ==1)
            return nums[0];
        else if(len==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        nums[2] = nums[2]+nums[0];
        int idx = 3;
        while(idx<len){
            nums[idx] += nums[idx-2]>nums[idx-3]?nums[idx-2]:nums[idx-3];
            idx++;
        }
        return nums[len-1]>nums[len-2]?nums[len-1]:nums[len - 2];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(hr.rob(nums));
    }
}
