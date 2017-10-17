package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class UniqueBinarySearchTrees {

    //math
    public int numTrees(int n) {
        double result = 1;
        for (int i=0;i<n;i++){
            result *= (2*n-i);
            result /= n-i;
        }
        result = result/(n+1);
        //System.out.println(result);
        return (int)Math.round(result);
    }

    //dp
    public int numTrees02(int n ){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
        System.out.println(ub.numTrees02(3));
    }
}
