package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-7-20.
 */
public class BubbleSort {
    public void sort(int[] nums){
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            for (int j = 0; j < len - 1 - i; j++) {
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,6,4,5,8,6,9,0};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
