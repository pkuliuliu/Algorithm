package com.liu.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-6-29.
 */
public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * For example, Given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence is [1,2, 3, 4].
     * Return its length: 4.
     * Your algorithm should run in O(n) complexity
     */
    public int longestConsecutive(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int num : nums){
            if(map.containsKey(num)){
                continue;
            }
            int cnt = map.getOrDefault(num-1,0)+map.getOrDefault(num+1,0)+1;
            map.put(num,cnt);
            max = Math.max(cnt,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
