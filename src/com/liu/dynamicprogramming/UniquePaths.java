package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-18.
 */
public class UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     * @param m
     * @param n
     * @return
     * the result same of C(n-1+m-1,m-1)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }

    public int uniquePaths02(int m, int n) {
        int _n = n+m-2;
        int _m = m-1;
        int num1 = 1;
        int num2 = 1;

        for(int i=0;i<_m;i++){
            num1*=_n-i;
            num2*=_m-i;
        }
        return num1/num2;
    }


    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths02(3,7));
    }
}
