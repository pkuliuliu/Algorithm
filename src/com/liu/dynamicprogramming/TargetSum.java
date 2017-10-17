package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class TargetSum {
    /**
     * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
     * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
     * Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:
     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:
     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3
     There are 5 ways to assign symbols to make the sum of nums be target 3.
     */

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return Math.abs(nums[0])==Math.abs(S)?1:0;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i]>0?nums[i]:-nums[i];
        }
        if(S>sum||-S>sum){
            return 0;
        }
        int[][] dp = new int[len][2*sum+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < 2 * sum + 1; i++) {
            dp[0][i] = 0;
        }
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        return helper(dp,nums,len-1,S,sum);
    }

    public int helper(int[][] dp,int[] nums,int idx,int S,int sum){
        if(dp[idx][sum + S]!=-1){
            return dp[idx][sum + S];
        }

        int res = 0;
        if(sum + S-nums[idx]<0){
            res+=0;
        }else {
            int temp = helper(dp, nums, idx - 1, S - nums[idx], sum);
            res += temp;
        }

        if(sum + S + nums[idx]>=2*sum+1){
            res+=0;
        }else {
            int temp = helper(dp,nums,idx-1,S+nums[idx],sum);
            res += temp;
        }
        dp[idx][sum + S] = res;
        return res;
    }

    /**
     * another way
     */
    /**
     public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2);
     }

     private int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
            dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
     }

     *
     */
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int res = ts.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1);
        System.out.println(res);
        res = ts.findTargetSumWays(new int[]{1,2,7,9,981},100000000);
        System.out.println(res);
        res = ts.findTargetSumWays(new int[]{1,1,1,1,1},3);
        System.out.println(res);
    }
}
