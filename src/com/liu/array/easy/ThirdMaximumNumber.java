package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class ThirdMaximumNumber {

    /**
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int cnt=1;
        int i=nums.length - 1;
        while(i>0&&cnt<3){
            if(nums[i]!=nums[i-1]){
                cnt++;
            }
            i--;
        }
        if(cnt==3){
            return nums[i];
        }else{
            return nums[nums.length-1];
        }
    }

    public int thirdMax02(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{2,2,1}));
        System.out.println(new ThirdMaximumNumber().thirdMax02(new int[]{2,2,1}));
    }
}
