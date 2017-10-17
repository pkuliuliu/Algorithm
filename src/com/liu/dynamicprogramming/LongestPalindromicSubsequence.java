package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class LongestPalindromicSubsequence {
    /**
     * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
     Example 1:
     Input:

     "bbbab"
     Output:
     4
     One possible longest palindromic subsequence is "bbbb".
     Example 2:
     Input:

     "cbbd"
     Output:
     2
     One possible longest palindromic subsequence is "bb".
     */


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
        return helper(0,len-1,chars,dp);
    }

    public int helper(int i,int j,char[] chars,int[][] dp){
        if(i>j||i>=chars.length||j<0)
            return 0;
        if(dp[i][j]>0)
            return dp[i][j];
        if(i==j) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        int left = helper(i,j-1,chars,dp);
        int right = helper(i+1,j,chars,dp);
        int middle = helper(i+1,j-1,chars,dp)+(chars[i]==chars[j]?2:0);
        dp[i][j] = Math.max(left,Math.max(right,middle));
        return dp[i][j];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lp = new LongestPalindromicSubsequence();
        System.out.println(lp.longestPalindromeSubseq("bbbab"));
    }
}
