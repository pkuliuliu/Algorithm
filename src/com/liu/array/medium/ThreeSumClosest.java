package com.liu.array.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-6-29.
 */
public class ThreeSumClosest {
    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * the sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * 先排序，选择第一个a，，然后采用两端逼近的方法：找两个数之和最接近target-a的b和c
     */
    public int threeSumClosest(int[] nums,int target){
        int result=0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low=i+1;
            int high = nums.length-1;
            while(low<high){
                int value = nums[high]+nums[low]+nums[i];
                if(value==target){
                    return value;
                }else if(value>target){
                    high--;
                }else {
                    low++;
                }
                int gap =Math.abs(value-target);
                if(gap<minGap){
                    result = value;
                    minGap=gap;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4},-3));
    }
}
