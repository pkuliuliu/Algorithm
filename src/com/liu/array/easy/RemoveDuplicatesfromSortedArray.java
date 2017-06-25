package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class RemoveDuplicatesfromSortedArray {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     * @param nums
     * @return
     * 此题解法与MoveZeroes相似
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int i=1,k=1;
        while(i<nums.length){
            if(nums[i]==nums[i-1]){
                i++;
            }else {
                nums[k++] = nums[i++];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
