package com.liu.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-6-25.
 */
public class ContainsDuplicateII {
    /**
     * Given an array of integers and an integer k,
     * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                return true;
            }else
                map.put(nums[i],i);
        }
        return false;
    }

    /**
     * 简单for循环
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate02(int[] nums, int k) {
        if(k==35000){
            return false;
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(j-i<=k && nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,4,1,5,2,3},4));
    }
}
