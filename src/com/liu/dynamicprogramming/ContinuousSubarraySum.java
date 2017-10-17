package com.liu.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liu on 17-8-10.
 */
public class ContinuousSubarraySum {
    /**
     * Given a list of non-negative numbers and a target integer k,
     * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
     *
     Example 1:
     Input: [23, 2, 4, 6, 7],  k=6
     Output: True
     Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     Example 2:
     Input: [23, 2, 6, 4, 7],  k=6
     Output: True
     Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     Note:
     The length of the array won't exceed 10,000.
     You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     */

    public boolean checkSubarraySum02(int[] nums, int k) {
        int len = nums.length;
        k = Math.abs(k);
        if(k==0){
            for(int i=0;i<len-1;i++){
                if(nums[i]==0&&nums[i+1]==0)
                    return true;
            }
            return false;
        }
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i]%k;
            for (int j = i+1; j < len; j++) {
                dp[i][j] = (dp[i][j-1]+nums[j])%k;
                if(dp[i][j]==0)
                    return true;
            }
        }
        return false;
    }

    // 迭代求和，，，对k取余，，若某个值出现两次，，，sum(0,i) == sum(0,j),且i+1<j;则说明sum(i,j)==0
    public boolean checkSubarraySum(int[] nums,int k){
        int len = nums.length;
        if(len<2)
            return false;

        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);//！！！！
        for (int i = 0; i < len; i++) {
            sum = (sum+nums[i]);
            if(k!=0)
                sum = sum%k;
            if(map.containsKey(sum)) {
                if (map.get(sum) + 1 < i)
                    return true;
            }else
                map.put(sum,i);
        }
        return false;
    }
    public static void main(String[] args) {
        ContinuousSubarraySum cs = new ContinuousSubarraySum();
        System.out.println(cs.checkSubarraySum(new int[]{1,0,1},-1));
    }
}
