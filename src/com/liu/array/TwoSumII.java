package com.liu.array;

import java.util.Arrays;

/**
 * Created by liu on 17-6-22.
 */
public class TwoSumII {
    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while(low<high){
            int val = numbers[low]+numbers[high];
            if(val == target){
                return new int[]{low+1,high+1};
            }else if(val>target){
                high--;
            }else {
                low++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSum(new int[]{2,7,11,15},9)));
    }
}
