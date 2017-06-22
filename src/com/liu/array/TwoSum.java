package com.liu.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-6-22.
 */
public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *      Given nums = [2, 7, 11, 15], target = 9,
     *      Because nums[0] + nums[1] = 2 + 7 = 9,
     *      return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer k = map.getOrDefault(target-nums[i],null);
            if(k!=null){
                return new int[]{k,i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2,7,11,15},9)));
    }
}
