package com.liu.array.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-6-28.
 */
public class RemoveDuplicatesfromSortedArrayII {
    /**
     * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
     * For example, Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3]
     */

    public int removeDuplicates(int[] nums){
        int target=nums[0];
        int cnt=1;
        int idx=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==target){
                cnt++;
                if(cnt<=2){
                    nums[idx++]=nums[i];
                }
            }else{
                target=nums[i];
                cnt=1;
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }

    static void test(int[] nums){

        System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        test(nums);
    }
}
