package com.liu.string.easy;

/**
 * Created by liu on 17-7-7.
 */
public class DetectCapital {

    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.

     We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital if it has more than one letter, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way.
     Example 1:
     Input: "USA"
     Output: True
     Example 2:
     Input: "FlaG"
     Output: False
     Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(len<=1)
            return true;
        boolean flag = 'A'<=word.charAt(0)&&word.charAt(0)<='Z';
        if(!flag && ('A'<=word.charAt(1)&&word.charAt(1)<='Z')){
            return false;
        }else
            flag = 'A'<=word.charAt(1)&&word.charAt(1)<='Z';
        for (int i = 2; i < len; i++) {
            boolean key = 'A'<=word.charAt(i)&&word.charAt(i)<='Z';//注意逻辑运算的时候用
            if(flag != key)//flag != 'A'<=word.charAt(i)&&word.charAt(i)<='Z'是错误的用法==》flag != ('A'<=word.charAt(i)&&word.charAt(i)<='Z')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new DetectCapital().detectCapitalUse("USA"));
        //System.out.println(new DetectCapital().detectCapitalUse("FlaG"));
        //System.out.println(new DetectCapital().detectCapitalUse("leetcode"));
        //System.out.println(new DetectCapital().detectCapitalUse("Google"));
        System.out.println(new DetectCapital().detectCapitalUse("GGGGGGGg"));
    }
}
