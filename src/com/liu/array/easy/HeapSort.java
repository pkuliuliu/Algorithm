package com.liu.array.easy;


import java.util.Arrays;

/**
 * Created by liu on 17-7-20.
 */
public class HeapSort {
    public void sort(int[] nums){
        int idx = nums.length-1;
        initHeap(nums);
        System.out.println(Arrays.toString(nums));
        while(idx>=0){
            int tmp = nums[idx];
            nums[idx] = nums[0];
            nums[0] = tmp;
            adjustHeap(nums,0,idx);
            idx--;
        }
    }
    public void initHeap(int[] nums){
        int idx = (nums.length-2)/2;
        while(idx>=0){
            adjustHeap(nums,idx,nums.length);
            idx--;
        }
    }
    public void adjustHeap(int[] nums,int idx, int endidx){
        int len = nums.length;
        if(idx>(endidx-2)/2){
            return;
        }
        if(2*idx+2<endidx&&nums[2*idx+2]>nums[idx]&&nums[2*idx+2]>nums[2*idx+1]){
            int tmp = nums[2*idx+2];
            nums[2*idx+2] = nums[idx];
            nums[idx] = tmp;
            adjustHeap(nums,2*idx+2,endidx);
        }else if(2*idx+1<endidx&&nums[2*idx+1]>nums[idx]){
            int tmp = nums[idx];
            nums[idx] = nums[2*idx+1];
            nums[2*idx+1] = tmp;
            adjustHeap(nums,2*idx+1,endidx);
        }
    }

    public static void main(String[] args) {
        HeapSort headSort = new HeapSort();
        int[] nums = new int[]{1,3,2,5,4,7,6,9,8,0};
        headSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
