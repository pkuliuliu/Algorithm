package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-9.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        int idx = 1;
        int len = nums.length;
        while(idx<len){
            sum = (sum>0?sum:0)+nums[idx];
            max = max>sum?max:sum;
            idx++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(ms.maxSubArray(nums));
    }
}
