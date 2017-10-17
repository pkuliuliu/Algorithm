package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-18.
 */
public class OnesandZeroes {
    /**
     *
     * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
     *
     * For now, suppose you are a dominator of m 0s and n 1s respectively.
     * On the other hand, there is an array with strings consisting of only 0s and 1s.
     *
     * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
     * Each 0 and 1 can be used at most once.

     Note:
     The given numbers of 0s and 1s will both not exceed 100
     The size of given string array won't exceed 600.

     Example 1:
     Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     Output: 4

     Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m+1][n+1];

        int res = 0;
        for(String str : strs){
            if(helper(str,m,n)){
                res += 1;
            }
        }
        return res;
    }
    private boolean helper(String str,int m,int n){
        int len = str.length();
        if(len>m+n)
            return false;
        for(char ch : str.toCharArray()){
            if(ch == '1'){
                n--;
            }else {
                m--;
            }
        }
        return m>=0&&n>=0;
    }
}
