package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class ArrayPartitionI {
    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum+=nums[2*i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayPartitionI().arrayPairSum(new int[]{1,4,3,2}));
    }
}
