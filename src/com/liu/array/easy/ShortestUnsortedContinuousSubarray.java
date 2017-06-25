package com.liu.array.easy;

/**
 * Created by liu on 17-6-23.
 */
public class ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order, too.
     * You need to find the shortest such subarray and output its length.
     * Example 1:
     *      Input: [2, 6, 4, 8, 10, 9, 15]
     *      Output: 5
     *      Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        /**
         * 解法。。选择排序的变种
         */
        int len = nums.length;
        int low=-1;
        for (int i = 0; i < len; i++) {
            int k=i;
            for(int j=i+1;j<len;j++){
                if(nums[j]<nums[k]){
                    k=j;
                    break;
                }
            }
            if(k!=i){
                low=i;
                break;
            }
        }
        if(low==-1)
            return 0;
        int high=-1;
        for (int i = len-1; i >-1; i--) {
            int k=i;
            for(int j=i-1;j>-1;j--){
                if(nums[j]>nums[k]){
                    k=j;
                    break;
                }
            }
            if(k!=i){
                high=i;
                break;
            }
        }
        return high-low==0?0:high-low+1;
    }

    /**
     * 一趟for循环中，如果当前值nums[i]比当前最大值小，说明应该调整当前值的位置，将end标记为i
     * 同理，如果当前值nums[i]比当前最小值大，说明当前值应该调整，将start标记为i
     * @param nums
     * @return
     */
    public int findUnsortedSubarray02(int[] nums) {
        // corner case
        if(nums == null || nums.length == 1) {
            return 0;
        }

        int start = -1; // start index of unsorted subarray
        int end = -2;   // end index of unsorted subarray
        int last = nums.length - 1; // last index of nums[]
        int max = nums[0];  // maximum so far
        int min = nums[last];   // minimum so far

        for(int i = 0; i <= last; i++) {
            if(nums[i] < max) {
                end = i;
            }
            else {
                max = nums[i];
            }

            if(nums[last - i] > min) {
                start = last - i;
            }
            else {
                min = nums[last - i];
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }
}
