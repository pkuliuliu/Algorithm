package com.liu.array.medium;

/**
 * Created by liu on 17-6-28.
 */
public class SearchinRotatedSortedArray {
    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     */

    public int search(int[] nums, int target){
        int len = nums.length;
        if(target>nums[len-1]&&target<nums[0]){
            return -1;
        }
        if(len==1){
            return nums[0]==target?0:-1;
        }
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                if(target>=nums[0]||nums[mid]<=nums[len-1]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else{//nums[mid]<target
                if(nums[mid]>=nums[0]||target<=nums[len-1]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public int search02(int[] nums, int target){
        int len = nums.length;
        if(target>nums[len-1]&&target<nums[0]){
            return -1;
        }
        if(len==1){
            return nums[0]==target?0:-1;
        }
        int low=0;
        int high =len-1;
        if(target>=nums[0]){
            high = findMax(nums);
        }else {
            low=findMax(nums)+1;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int findMax(int[] nums){
        int len = nums.length;
        if(len<=1){
            return 0;
        }
        if(len==2){
            return nums[1]>nums[0]?1:0;
        }
        if(nums[len-1]>nums[0]){
            return len-1;
        }

        int low=0,high=len-2;
        int mid = (low+high)/2;
        while(low<=high){
            if(nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid]>=nums[0]){
                low = mid;
            }else{
                high = mid;
            }
            mid = (low+high)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{1,3,0,0},3));
    }
}
