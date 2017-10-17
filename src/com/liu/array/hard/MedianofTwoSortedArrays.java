package com.liu.array.hard;

/**
 * Created by liu on 17-7-20.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1==0)
            if(len2%2==0)
                return (nums2[len2/2-1]+nums2[len2/2])/2.0;
            else {
                return nums2[len2/2];
            }
        if(len2==0){
            if(len1%2==0)
                return (nums1[len1/2-1]+nums1[len1/2])/2.0;
            else
                return nums1[len2/2];
        }
        if((len1+len2)%2!=0)
            return findKthValue(nums1,0,len1-1,nums2,0,len2-1,(len1+len2+1)/2)*1.0;
        else {
            int res1 = findKthValue(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2);
            int res2 = findKthValue(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 2) / 2);
            System.out.println(res1+"\t"+res2);
            return (res1+res2) / 2.0;
        }
    }

    public int findKthValue(int[] nums1,int begin1,int end1,int[] nums2,int begin2,int end2,int k){
        if(begin1>end1){
            return nums2[begin2 + k - 1];
        }
        if(begin2>end2){
            return nums1[begin1 + k - 1];
        }
        if(k==1)
            return Math.min(nums1[begin1],nums2[begin2]);

        int len1 = Math.min(k/2,end1 - begin1 + 1);
        int len2 = Math.min(k/2,end2 - begin2 + 1);
        int idx1 = begin1 + len1-1;
        int idx2 = begin2 + len2-1;
        if(nums1[idx1]==nums2[idx2]){
            if(len1+len2==k)
                return nums1[idx1];
            else{
                return findKthValue(nums1,idx1+1,end1,nums2,idx2+1,end2,k-len2-len1);
            }
        }else{
            if(nums1[idx1]>nums2[idx2]){
                return findKthValue(nums1,begin1,end1,nums2,idx2+1,end2,k-len2);
            }else{
                return findKthValue(nums1,idx1+1,end1,nums2,begin2,end2,k-len1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
