package com.liu.string.easy;

/**
 * Created by liu on 17-7-7.
 */
public class LongestCommonPrefix {
    /**
     *    Write a function to find the longest common prefix string amongst an array of strings.
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs.length==0){
            return result.toString();
        }
        int min = Integer.MAX_VALUE;
        for(String str:strs){
            int tmp = str.length();
            if(min>tmp)
                min=tmp;
        }
        if(min==0){
            return result.toString();
        }
        for (int i = 0; i < min; i++) {
            char current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(current!=strs[j].charAt(i)){
                    return String.valueOf(result);
                }
            }
            result.append(current);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"abcde","abc","abcd","ab"}));
    }
}
