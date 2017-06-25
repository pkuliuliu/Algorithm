package com.liu.array.easy;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liu on 17-6-24.
 */
public class KdiffPairs {
    /**
     * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
     * Here a k-diff pair is defined as an integer pair (i, j),
     * where i and j are both numbers in the array and their absolute difference is k.
     *
     * Input: [3, 1, 4, 1, 5], k = 2
     Output: 2
     Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
     Although we have two 1s in the input, we should only return the number of unique pairs.
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {

        if(k<0)
            return 0;
        int cnt=0;
        if(k==0){
            Map<Integer,Boolean> map = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    if(map.get(nums[i])==false){
                        cnt++;
                        map.put(nums[i],true);
                    }
                }else
                    map.put(nums[i],false);
            }
        }else{
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<nums.length; i++){
                if(set.contains(nums[i]))
                    continue;
                if(set.contains(nums[i] - k))
                    cnt++;
                if(set.contains(nums[i]+k))
                    cnt++;
                set.add(nums[i]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new KdiffPairs().findPairs(new int[]{1,2,1,1},0));
    }
}
