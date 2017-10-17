package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-28.
 */
public class CoinChange {
    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.

     Example 1:
     coins = [1, 2, 5], amount = 11
     return 3 (11 = 5 + 5 + 1)

     Example 2:
     coins = [2], amount = 3
     return -1.

     Note:
     You may assume that you have an infinite number of each kind of coin.
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return helper(dp,coins,amount);
    }
    public int helper(int[] dp,int[] coins,int amount){
        if(dp[amount]!=0||amount==0){
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            if(amount>=coins[i]){
                int tmp = helper(dp,coins,amount-coins[i]);
                if(tmp!=-1){
                    min = min<tmp?min:tmp;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            dp[amount] = -1;
        }else
            dp[amount] = min + 1;

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},11));
        System.out.println(new CoinChange().coinChange(new int[]{2,5},3));
    }
}
