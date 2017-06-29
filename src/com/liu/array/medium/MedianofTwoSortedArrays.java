package com.liu.array.medium;

/**
 * Created by liu on 17-6-28.
 */
public class MedianofTwoSortedArrays {
    /**
     * there are two sorted arrays A and B of size m and n respectively.
     * Find the median of the two sorted arrays.
     * the overall run time complexity should be O(log(m + n)).
     * 方法一：改造有序数组合并的方法，寻找第(m+m)/2个数
     *  方法二：折半查找：
     */
    public int findMedianSortedArrays(int[] nums1,int[] nums2){
        return findKthNumber(nums1,0,nums1.length,nums2,0,nums2.length,(nums1.length+nums2.length)/2+1);
    }
    public int findKthNumber(int[] nums1,int begin1,int end1,int[] nums2,int begin2,int end2,int k){
        if(begin1>end1||begin2>end2)
            return -1;
        if(k==1){
            return Math.min(nums1[begin1],nums2[begin2]);
        }
        int m1 = end1-begin1+1>=k/2?begin1+k/2-1:end1;
        int m2 = end2-begin2+1>=k/2?begin2+k/2-1:end2;
        if(nums1[m1]==nums2[m2]){
            return nums1[m1];
        }else if(nums1[m1]>nums2[m2]){
            return findKthNumber(nums1,begin1,end1,nums2,m2+1,end2,k-(m2-begin2+1));
        }else {
            return findKthNumber(nums1,m1+1,end1,nums2,begin2,end2,k-(m1-begin1+1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3,5,7,9},new int[]{2,4,6,8,10,12}));
    }
}
