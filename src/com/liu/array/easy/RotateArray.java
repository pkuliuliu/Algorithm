package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class RotateArray {
    /**
     * Rotate an array of n elements to the right by k steps.
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * Note:
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k=k%nums.length;//去除k>length的影响
        helper(nums,0,nums.length-k-1);
        helper(nums,nums.length-k,nums.length-1);
        helper(nums,0,nums.length-1);
    }
    public void helper(int[] nums,int low, int high){
        while(low<high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new RotateArray().rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
