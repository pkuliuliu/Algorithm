package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-18.
 */
public class FindSubSetSum {
    //give a array of no-negative value, find all the subSet to get the target value by plus
    //e.g.  [1,1,1,1,1]  target 4; return 5
    public int subSetSum(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;//important
        for (int i = 0; i < target + 1; i++) {
            for (int j = target - nums[i]; j >= 0; j--) {
                dp[j+nums[i]] += dp[j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
