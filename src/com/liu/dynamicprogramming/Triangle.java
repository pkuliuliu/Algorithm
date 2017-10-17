package com.liu.dynamicprogramming;

import java.util.List;

/**
 * Created by liu on 17-8-10.
 */
public class Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

     For example, given the following triangle
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

     Note:
     Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==0)
            return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j = i;j>=1;j--){
                dp[j] = triangle.get(i).get(j)+Math.min(dp[j],dp[j-1]);
            }
            dp[0] = triangle.get(i).get(0) + dp[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(dp[i]<min)
                min = dp[i];
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
