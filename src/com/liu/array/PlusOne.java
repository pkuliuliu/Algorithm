package com.liu.array;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class PlusOne {
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     * You may assume the integer do not contain any leading zero, except the number 0 itself.
     * The digits are stored such that the most significant digit is at the head of the list.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for(int i=0;i<digits.length;i++){
            if(digits[i]!=9){
                flag=true;
            }
        }
        if(flag==false){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else{
            for(int i=digits.length-1;i>-1;i--){
                if(digits[i]==9){
                    digits[i]=0;
                }else{
                    digits[i]=digits[i]+1;
                    return digits;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1,0,1,0,1,0};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));

    }
}
