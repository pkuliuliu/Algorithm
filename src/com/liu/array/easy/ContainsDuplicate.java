package com.liu.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liu on 17-6-25.
 */
public class ContainsDuplicate {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 自定义hash
     * @param nums
     * @return
     */
    public boolean containsDuplicate02(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }
        boolean[] index = new boolean[max - min + 1];
        for(int num : nums){
            if(index[num-min])
                return true;
            else
                index[num-min] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,7,4,5,6}));
    }
}
