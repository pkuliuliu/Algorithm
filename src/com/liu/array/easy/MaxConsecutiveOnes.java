package com.liu.array.easy;

/**
 * Created by liu on 17-6-22.
 */
public class MaxConsecutiveOnes {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * Example 1:
     *      Input: [1,1,0,1,1,1]
     *      Output: 3
     *      Explanation: The first two digits or the last three digits are consecutive 1s.
     *      The maximum number of consecutive 1s is 3.
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                cnt++;
            }else {
                max = max>cnt?max:cnt;
                cnt=0;
            }
        }
        return max>cnt?max:cnt;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
