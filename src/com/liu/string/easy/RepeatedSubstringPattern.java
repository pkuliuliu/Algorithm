package com.liu.string.easy;

/**
 * Created by liu on 17-7-7.
 */
public class RepeatedSubstringPattern {
    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

     Example 1:
     Input: "abab"

     Output: True

     Explanation: It's the substring "ab" twice.
     Example 2:
     Input: "aba"

     Output: False
     Example 3:
     Input: "abcabcabcabc"

     Output: True

     Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len/2; i >0; i--) {
            if(len%i==0&&s.matches("("+s.substring(0,i)+")+")){
                return true;
            }
        }
        return false;
    }

    public boolean helper(String s,String sub){
        //return  Pattern.compile("("+sub+")+").matcher(s).matches();
        return s.matches("("+sub+")+");
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aaaaaaaaaaaaaaaaaaaaa"));
    }
}
