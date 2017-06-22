package com.liu.array;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class RemoveElement {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *      Example:
     *      Given input array nums = [3,2,2,3], val = 3
     *      Your function should return length = 2, with the first two elements of nums being 2.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i=0,k=0;
        while(i<nums.length){
            if(nums[i]==val){
                i++;
            }else{
                nums[k++] = nums[i++];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new RemoveElement().removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }
}
