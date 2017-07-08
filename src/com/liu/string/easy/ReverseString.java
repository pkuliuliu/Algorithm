package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class ReverseString {
    /**
     * Write a function that takes a string as input and returns the string reversed.

     Example:
     Given s = "hello", return "olleh".
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len==0){
            return s;
        }

        for (int i = 0; i < len/2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len-i-1];
            chars[len-i-1] = tmp;
        }
        return String.valueOf(chars);
    }

    public String reverseString02(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len==0){
            return s;
        }

        for (int i = 0,j=len-1; i < j; i++,j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString02("hello"));
    }
}
