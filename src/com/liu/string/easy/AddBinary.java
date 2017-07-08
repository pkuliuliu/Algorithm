package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".
     */

    public String addBinary(String a, String b) {
        String result = "";
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i>=0||j>=0){
            int sum = carry;
            if(i>=0){
                sum+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum+=b.charAt(j)-'0';
                j--;
            }
            result = sum%2+result;
            carry = sum/2;
        }
        if(carry>0){
            result = carry+result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11","1"));
    }
}
