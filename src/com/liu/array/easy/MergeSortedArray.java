package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-25.
 */
public class MergeSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * You may assume that nums1 has enough space
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>-1&&j>-1){
            if(nums1[i]>nums2[j]){
               nums1[k--]=nums1[i--];
            }else {
                nums1[k--]=nums2[j--];
            }
        }
        if(i==-1){
            while(j>-1){
                nums1[k--]=nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,6,7,0,0,0,0};
        int[] nums2 = new int[]{2,4,8,9};
        new MergeSortedArray().merge(nums1,5,nums2,4);
        System.out.println(Arrays.toString(nums1));
    }
}
