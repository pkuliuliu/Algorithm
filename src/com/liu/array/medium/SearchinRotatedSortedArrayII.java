package com.liu.array.medium;

/**
 * Created by liu on 17-6-28.
 */
public class SearchinRotatedSortedArrayII {
    /**
     * Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array.
     */

    public boolean search(int [] nums,int target) {
        int len = nums.length;
        if (target > nums[len - 1] && target < nums[0]) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }
        int first = 0;
        int low = 0;
        int high = len - 1;
        while (nums[low] == nums[high]) {
            low++;
            first++;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                if (target >= nums[first] || nums[mid] <= nums[len - 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//nums[mid]<target
                if (nums[mid] >= nums[first] || target <= nums[len - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArrayII().search(new int[]{2,3,1,1,1},1));
    }
}
