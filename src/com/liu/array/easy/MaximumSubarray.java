package com.liu.array.easy;

/**
 * Created by liu on 17-6-24.
 */
public class MaximumSubarray {
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        int i=0;
        while(i<nums.length){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            max = Math.max(max,sum);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
