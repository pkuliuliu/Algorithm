package com.liu.array.easy;

/**
 * Created by liu on 17-6-22.
 */
public class SearchInsertPosition {
    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return nums[low]<target?low+1:low;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},4));
    }
}
