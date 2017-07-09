package com.liu.string.medium;

import java.util.Arrays;

/**
 * 最长回文子串
 * Created by liu on 17-7-9.
 */
public class LongestPalindronSubstring {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     Example:
     Input: "babad"
     Output: "bab"
     Note: "aba" is also a valid answer.
     Example:
     Input: "cbbd"
     Output: "bb"
     * @param s
     * @return
     */

    int max, lo;

    /**
     * 每个位置向两头扩散能够得到以该位置为中心的最大奇数回文子串
     * 每两个相邻位置向两头扩散可以得当前位置的最大偶数回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if(s == null || s.length() < 2){
            return s;
        }

        for(int i = 0; i < s.length() - 1; i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }


        return s.substring(lo, max + lo);
    }

    public void helper(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        if(max < j - i - 1){
            max = j - i - 1;
            lo = i + 1;
        }
    }











    public String longestPalindrome02(String s) {
//        int len = s.length();
//        int[] keys = new int[]{0,1};
//        f(s,0,len-1,keys);
//        System.out.println(keys[0]+" "+keys[1]);
//        return s.substring(keys[0],keys[1]+keys[0]);
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        int key = 0;
        int cnt = 1;
        for(int j=0;j<len;j++){
            for(int i=j;i>=0;i--){
                if(i==j){
                    flag[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j)){
                    if(i+1<=j-1&&!flag[i+1][j-1]) {
                        flag[i][j] = false;
                    }else{
                        flag[i][j] = true;
                        if (j - i + 1 > cnt) {
                            key = i;
                            cnt = j - i + 1;
                        }
                    }
                }else
                    flag[i][j] = false;
            }
        }
        return s.substring(key,key+cnt);
    }

    boolean f(String s,int i,int j,int[] keys){
        if(i>=j)
            return true;
        if(s.charAt(i)==s.charAt(j)&&f(s,i+1,j-1,keys)){
            if(keys[1] < j-i+1) {
                keys[0] = i;
                keys[1] = j - i + 1;
            }
            return true;
        }else {
            f(s,i+1,j,keys);
            f(s,i,j-1,keys);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindronSubstring().longestPalindrome("babad"));
    }
}
