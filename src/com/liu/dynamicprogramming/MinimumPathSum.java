package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class MinimumPathSum {
    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];

        dp[0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }

        for(int i = 1;i<rows;i++){
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < cols; j++) {
                dp[j] = grid[i][j]+Math.min(dp[j-1],dp[j]);
            }
        }
        return dp[cols-1];
    }

    public static void main(String[] args) {
        MinimumPathSum mm = new MinimumPathSum();
        System.out.println(mm.minPathSum(new int[][]{{1,2},{1,1}}));
    }
}
