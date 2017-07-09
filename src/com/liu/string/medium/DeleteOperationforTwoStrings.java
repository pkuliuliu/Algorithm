package com.liu.string.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-7-8.
 */
public class DeleteOperationforTwoStrings {
    /**
     * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

     Example 1:
     Input: "sea", "eat"
     Output: 2
     Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     Note:
     The length of given words won't exceed 500.
     Characters in given words can only be lower-case letters.

     ---最长公共子序列。。。
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
//        int length = helper(word1,word2,len1,len2);
        int length = helper2(word1,word2);
        return len1+len2-2*length;
    }

    /**
     * 非递归
     * @param word1
     * @param word2
     * @return
     */
    private int helper2(String word1,String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] l = new int[len1+1][len2+1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    l[i][j] = l[i-1][j-1]+1;
                }else {
                    l[i][j] = Math.max(l[i-1][j],l[i][j-1]);
                }
            }
        }
        return l[len1][len2];
    }

    /**
     * 递归
     * @param word1
     * @param word2
     * @param i
     * @param j
     * @return
     */
    private int helper(String word1,String word2,int i, int j){
        if(i==0||j==0){
            return 0;
        }else {
            int result=0;
            if (word1.charAt(i-1)==word2.charAt(j-1)){
                result = helper(word1,word2,i-1,j-1)+1;
            }else {
                result = Math.max(helper(word1,word2,i-1,j),helper(word1,word2,i,j-1));
            }
            return result;
        }
    }
    public static void main(String[] args) {
        System.out.println(new DeleteOperationforTwoStrings().minDistance("horse","ros"));
    }
}
