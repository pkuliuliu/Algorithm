package com.liu.array.easy;

/**
 * Created by liu on 17-6-24.
 */
public class MissingNumber {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     *
     * For example,
     * Given nums = [0, 1, 3] return 2.
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i]^(i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{0,1,3}));
    }
}
