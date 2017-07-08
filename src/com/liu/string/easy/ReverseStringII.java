package com.liu.string.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-7-7.
 */
public class ReverseStringII {
    /**
     * Given a string and an integer k,
     * you need to reverse the first k characters for every 2k characters counting from the start of the string.
     * If there are less than k characters left, reverse all of them.
     * If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and left the other as original.
     Example:
     Input: s = "abcdefg", k = 2
     Output: "bacdfeg"
     Restrictions:
     The string consists of lower English letters only.
     Length of the given string and k will in the range [1, 10000]
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        while(i<len){
            stringBuilder.append(new StringBuilder(s.substring(i,i+k>len?len:i+k)).reverse());
            i=i+k;
            if(i<len)
                stringBuilder.append(new StringBuilder(s.substring(i,i+k>len?len:i+k)));
            i=i+k;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg",2));
        char[] chars = "abcdefghijklmn".toCharArray();
        System.out.println(String.valueOf(chars));
        System.out.println(chars.toString());
        System.out.println(Arrays.toString(chars));
    }
}
