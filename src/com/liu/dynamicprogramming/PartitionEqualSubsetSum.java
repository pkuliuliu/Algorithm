package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-28.
 */
public class PartitionEqualSubsetSum {
    /**
     * Given a non-empty array containing only positive integers,
     * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

     Note:
     Each of the array element will not exceed 100.
     The array size will not exceed 200.
     Example 1:

     Input: [1, 5, 11, 5]

     Output: true

     Explanation: The array can be partitioned as [1, 5, 5] and [11].
     Example 2:

     Input: [1, 2, 3, 5]

     Output: false

     Explanation: The array cannot be partitioned into equal sum subsets.
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int[] dp = new int[sum/2+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            for (int j = sum/2;j>=0;j--){
                if(j>=nums[i]&&dp[j-nums[i]]==1){
                    dp[j] = 1;
                }
            }
            if(dp[sum/2]==1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,5,11,5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,2,3,5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,2,5}));
    }
}
