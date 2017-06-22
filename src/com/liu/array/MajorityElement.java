package com.liu.array;

/**
 * Created by liu on 17-6-22.
 */
public class MajorityElement {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cnt=0;
        int val=-1;
        int i=0;
        while(i<nums.length){
            if(cnt==0){
                val=nums[i];
                cnt++;
            }else if(val==nums[i]){
                cnt++;
            }else {
                cnt--;
            }
            i++;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1,2,1,2,1,2,1,1}));
    }
}
