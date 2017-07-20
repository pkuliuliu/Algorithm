package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-7-20.
 */
public class SelectionSort {
    public void sort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len -1; i++) {
            int key = i;
            for (int j = i+1; j < len; j++) {
                if(nums[j]<nums[key]){
                    key = j;
                }
            }
            if(key!=i){
                int tmp = nums[key];
                nums[key] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,4,8,6,7,9,0};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
