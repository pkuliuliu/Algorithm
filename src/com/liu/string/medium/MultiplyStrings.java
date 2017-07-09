package com.liu.string.medium;

/**
 * Created by liu on 17-7-8.
 */
public class MultiplyStrings {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1==1&&num1.charAt(0)=='0'||len2==1&&num2.charAt(0)=='0')
            return "0";
        int[] nums = new int[len1+len2];
        for (int i = len1-1; i >=0 ; i--) {
            for (int j = len2-1; j >=0 ; j--) {
                int pos1 = i+j;
                int pos2 = i+j+1;
                int sum = nums[pos2] + (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                nums[pos2] = sum%10;
                nums[pos1] += sum/10;
            }
        }
        StringBuilder result = new StringBuilder();
        if(nums[0]!=0)
            result.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            result.append(nums[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("999","121"));
    }
}
