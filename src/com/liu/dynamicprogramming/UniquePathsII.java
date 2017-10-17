package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-18.
 */
public class UniquePathsII {
    /**
     * Follow up for "Unique Paths":

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     For example,
     There is one obstacle in the middle of a 3x3 grid as illustrated below.

     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     The total number of unique paths is 2.

     Note: m and n will be at most 100.

     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        if(rows<1)
            return 0;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if(obstacleGrid[i][0]!=1)
                dp[i][0] = 1;
            else
                break;
        }
        for (int i = 0; i < cols; i++) {
            if(obstacleGrid[0][i]!=1)
                dp[0][i] = 1;
            else
                break;;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j]!=1)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
