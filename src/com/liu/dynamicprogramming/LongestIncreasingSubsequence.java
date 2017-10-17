package com.liu.dynamicprogramming;


/**
 * Created by liu on 17-8-27.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2){
            return len;
        }
        int res = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1;i<len;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    max = max>dp[j]?max:dp[j];
                }
            }
            dp[i] = 1 + max;
            res = res>dp[i]?res:dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
