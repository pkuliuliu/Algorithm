package com.liu.array.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by liu on 17-6-29.
 */
public class SingleNumberII {
    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * Note: Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     */
    public int singleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key)==1){
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{1,1,1,2,2,2,3,3,3,4}));
    }
}
