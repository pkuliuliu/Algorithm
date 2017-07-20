package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-7-20.
 */
public class InsertSort {
    public void sort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            while(j>0&&nums[j-1]>nums[j]){
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,2,3,4,8,9,0};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
