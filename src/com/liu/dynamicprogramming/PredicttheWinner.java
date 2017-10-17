package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-18.
 */
public class PredicttheWinner {
    /**
     * Given an array of scores that are non-negative integers.
     * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
     * Each time a player picks a number, that number will not be available for the next player.
     * This continues until all the scores have been chosen. The player with the maximum score wins.
     * Given an array of scores, predict whether player 1 is the winner.
     * You can assume each player plays to maximize his score.
             Example 1:
             Input: [1, 5, 2]
             Output: False
             Explanation: Initially, player 1 can choose between 1 and 2.
             If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
             So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
             Hence, player 1 will never be the winner and you need to return False.
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        int max = helper(nums,0,nums.length-1,sum);
        if(sum-max<=max){
            return true;
        }
        return false;
    }
    private int helper(int[] nums,int low,int high,int sum){
        if(low ==high)
            return nums[high];
        int left = helper(nums,low+1,high,sum-nums[low]);
        int right = helper(nums,low,high-1,sum-nums[high]);
        return Math.max(sum - left,sum - right);
    }

    /**
     *
     public boolean PredictTheWinner(int[] nums) {
        int n = nums.length, sum = 0;
        if(n % 2 == 0) return true;
         int[][] dp = new int[n][n];
         for(int i=0; i < n; i++) {
             dp[i][i] = nums[i];
            sum += nums[i];
        }

        for(int j = 0; j < n; j++){
            for(int i = j - 1; i >= 0; i--){
                int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
                int b = (i + 2 < n) ? dp[i + 2][ j] : 0;
                int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
            }
        }
         return dp[0][n - 1] * 2 >= sum;
     }
     */
    public static void main(String[] args) {
        PredicttheWinner pw = new PredicttheWinner();
        System.out.println(pw.PredictTheWinner(new int[]{1,5,2}));
        System.out.println(pw.PredictTheWinner(new int[]{1,5,233,7}));
    }
}
