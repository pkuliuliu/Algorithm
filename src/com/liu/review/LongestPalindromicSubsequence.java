package com.liu.review;

/**
 * Created by liu on 17-8-23.
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
        for(int col = 0;col<len;col++){
            for(int row = col;row>=0;row--){
                if(col==row){
                    dp[row][col]=1;
                }else if(chars[row]==chars[col]){
                    dp[row][col] = 2+(row+1>col-1?0:dp[row+1][col-1]);
                }else {
                    dp[row][col] = Math.max(dp[row+1][col],dp[row][col-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }
}
