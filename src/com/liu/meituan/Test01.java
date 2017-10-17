package com.liu.meituan;

/**
 * Created by liu on 17-8-31.
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(hepler(new int[]{2,3,3,1}));
    }
    public static boolean hepler(int[] nums){
        int max = nums[0];
        int sum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if(nums[i]>max) {
                max = nums[i];
            }
            sum+=nums[i];
        }
        return max<=sum/2;
    }
}
