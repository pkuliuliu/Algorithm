package com.liu.string.medium;

/**
 * 最长会问子序列
 * Created by liu on 17-7-9.
 */
public class LongestPalindromicSubsequence {
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
    /**
     * 非递归
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
//        return helper(s,0,s.length()-1);
        char[] chars = s.toCharArray();
        int len = s.length();
        String[][] result = new String[len][len];
        for (int i = 0; i < len; i++) {
            result[i][i] = s.charAt(i)+"";
        }
        for (int j = 1; j < len; j++) {
            for (int i = j-1; i >=0; i--) {
                if(chars[i]==chars[j]){
                    if(i+1>j-1){
                        result[i][j] = chars[i]+""+chars[j];
                    }else {
                        result[i][j] = chars[i]+result[i+1][j-1]+chars[j];
                    }
                }else {
                    String tmp1 = i+1>j?"":result[i+1][j];
                    String tmp2 = i>j-1?"":result[i][j-1];
                    result[i][j] = tmp1.length()>tmp2.length()?tmp1:tmp2;
                }
            }
        }
        return result[0][s.length()-1];
    }

    /**
     * 递归
     * @param s
     * @param i
     * @param j
     * @return
     */
    public String helper(String s,int i,int j){
        if(i>j){
            return "";
        }else if(i==j)
            return "" + s.charAt(i);
        else{
            if(s.charAt(i)==s.charAt(j)){
                String tmp = helper(s,i+1,j-1);
                System.out.println(tmp);
                return s.charAt(i)+tmp+s.charAt(j);
            }else{
                String tmp1 = helper(s,i+1,j);
                String tmp2 = helper(s,i,j-1);
                return tmp1.length()>tmp2.length()?tmp1:tmp2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindrome("aaasbcbdda"));
    }
}
