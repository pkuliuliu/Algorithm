package com.liu.dynamicprogramming;

import java.util.*;

/**
 * Created by liu on 17-8-27.
 */
public class LargestDivisibleSubset {
    /**
     * Given a set of distinct positive integers,
     * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
     *
     * If there are multiple solutions, return any subset is fine.

     Example 1:

     nums: [1,2,3]

     Result: [1,2] (of course, [1,3] will also be ok)
     Example 2:

     nums: [1,2,4,8]

     Result: [1,2,4,8]
     */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if(len<1)
            return new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        map.put(nums[0],tmp);
        int max = 1;
        List<Integer> res = tmp;
        int i = 1;
        while(i<len){
            tmp = new ArrayList<>();
            tmp.add(nums[i]);
            int _max = 0;
            List<Integer> maxpre = new ArrayList<>();
            for(int j = 0;j<i;j++){
                if(nums[i]%nums[j]==0&&map.get(nums[j]).size()>_max){
                    _max = map.get(nums[j]).size();
                    maxpre = map.get(nums[j]);
                }
            }
            if(_max>0){
                tmp.addAll(maxpre);
            }
            map.put(nums[i],tmp);
            if(_max+1>max){
                max = _max+1;
                res = tmp;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}
