package com.liu.dynamicprogramming;

import java.util.*;

/**
 * Created by liu on 17-8-18.
 */
public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * You may assume the dictionary does not contain duplicate words.

     For example, given
     s = "leetcode",
     dict = ["leet", "code"].

     Return true because "leetcode" can be segmented as "leet code"
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len];
        dp[0] = words.contains(s.substring(0,1));
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >=0; j--) {
                if(dp[j]&&words.contains(s.substring(j+1,i+1))){
                    dp[i] = true;
                    break;
                }
            }
            if(!dp[i])
                dp[i] = words.contains(s.substring(0,i+1));
        }
        return dp[len-1];
    }
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int len = s.length();
//        int[][] flag = new int[len][len];
//        return helper(s,0,len-1,new HashSet<>(wordDict),flag);
//    }
//
//    private boolean helper(String s, int low, int high, Set<String> wordDict, int[][] flag){
//        if(flag[low][high]!=0){
//            return flag[low][high]==1?true:false;
//        }
//
//        if(wordDict.contains(s.substring(low,high+1))){
//            flag[low][high] = 1;
//            return true;
//        }else {
//            for (int mid = low; mid < high; mid++) {
//                if(helper(s,low,mid,wordDict,flag)&&helper(s,mid+1,high,wordDict,flag)){
//                    flag[low][high] = 1;
//                    return true;
//                }
//            }
//        }
//        flag[low][high] = -1;
//        return false;
//    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        boolean res = wb.wordBreak("leetcode", Arrays.asList("leet","code"));
        System.out.println(res);
    }
}
