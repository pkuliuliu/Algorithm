package com.liu.array.medium;

/**
 * Created by liu on 17-6-29.
 */
public class SingleNumber {
    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public int singleNumber(int[] nums){
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1,1,2,3,2,4,4,5,5,6,6}));
    }
}
