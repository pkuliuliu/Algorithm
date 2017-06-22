package com.liu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 17-6-22.
 */
public class FindAllNumbersDisappeared {
    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //负标记法---注意使用绝对值表示下标
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1] = 0 - nums[Math.abs(nums[i])-1];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllNumbersDisappeared().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
