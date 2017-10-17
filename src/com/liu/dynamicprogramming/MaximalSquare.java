package com.liu.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by liu on 17-8-18.
 */
public class MaximalSquare {
    /**
     * Given a 2D binary matrix filled with 0's and 1's,
     * find the largest square containing only 1's and return its area.
     * For example, given the following matrix:
     *
     1 0 1 0 0
     1 0 1 1 1
     1 1 1 1 1
     1 0 0 1 0
     Return 4.
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows<=0)
            return 0;
//        for (int i = 0; i < rows; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res=0;
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0]-'0';
            res = res>dp[i][0]?res:dp[i][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j]-'0';
            res = res>dp[0][j]?res:dp[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    int corner = (int) Math.sqrt(dp[i - 1][j - 1]);
                    if (corner == 0) {
                        dp[i][j] = matrix[i][j] - '0';
                    } else {
                        int left = 1;
                        int top = 1;
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] - '0' != 0 && left - 1 < corner) {
                                left++;
                            }else
                                break;
                        }
                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] - '0' != 0 && top - 1 < corner) {
                                top++;
                            }else
                                break;
                        }
                        dp[i][j] = Math.min(left, top) * Math.min(left, top);
                    }
                    res = res > dp[i][j] ? res : dp[i][j];
                }
            }
        }

//        System.out.println();
//        for (int i = 0; i < rows; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return res;
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        System.out.println(ms.maximalSquare(new char[][]{"101101".toCharArray(),"111111".toCharArray(),"011011".toCharArray(),"111010".toCharArray(),"011111".toCharArray(),"110111".toCharArray()}));
    }
}
