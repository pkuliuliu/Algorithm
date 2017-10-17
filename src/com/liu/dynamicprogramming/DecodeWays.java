package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.
     */

    public int numDecodings(String s) {
        if(s.startsWith("0")||s.contains("00"))
            return 0;
        int len = s.length();
        if(len<2)
            return len;
        int a = 1;
        int b = 1;
        int result = 1;
        int idx = 1;
        while(idx<len){
            if(s.charAt(idx)=='0'){
                if(s.charAt(idx-1)>'2')
                    return 0;
                result = a;
                b = a;
                idx+=2;
            }else {
                int temp = (s.charAt(idx - 1) - '0') * 10 + (s.charAt(idx) - '0');
                result = b + (temp >= 1 && temp <= 26 ? a : 0);
                a = b;
                b = result;
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("123"));
    }
}
