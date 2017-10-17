package com.liu.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by liu on 17-8-29.
 */
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.

     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len<2)
            return 0;
        boolean[] dp = new boolean[len];
        char[] chars = s.toCharArray();
        for(int i = 1;i<len;i++){
            if(chars[i]!=')'){
                continue;
            }else {
                for (int j = i - 1; j >= 0; j--) {
                    if(dp[j]==true){
                        continue;
                    }else {
                        if((j==i-1||dp[j+1]==true)&&chars[j]=='('){
                            dp[i]=true;
                            dp[j]=true;
                            break;
                        }else
                            break;
                    }

                }
            }
        }
        int res = 0;
        int max = 0;
//        System.out.println(Arrays.toString(dp));
        for(int i=0;i<len;i++){
            if(dp[i]){
                res++;
            }else {
                max = max>res?max:res;
                res=0;
            }
        }
        return max>res?max:res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
