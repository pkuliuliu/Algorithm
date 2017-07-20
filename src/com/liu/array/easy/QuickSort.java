package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-7-20.
 */
public class QuickSort {
    public void sort(int[] nums,int begin,int end){
        if(begin>=end)
            return;
        int tmp = nums[begin];
        int key = begin;
        int i = begin+1;
        int j = end;
        while(i<=j){
            while (i<=j){
                if(nums[j]<=tmp){
                    nums[key] = nums[j];
                    key = j;
                    break;
                }
                j--;
            }

            while(i<=j){
                if(nums[i]>tmp){
                    nums[key] = nums[i];
                    key = i;
                    break;
                }
                i++;
            }
        }
        nums[key] = tmp;
        sort(nums,0,key-1);
        sort(nums,key+1,end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,4,7,6,9,8,0};
        new QuickSort().sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
