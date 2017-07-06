package com.liu.array.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-6-29.
 */
public class RemoveElement {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * the order of elements can be changed. It doesn’t maer what you leave beyond the new length.
     */
    public int removeElement(int[] nums,int elem){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            while(low<=high&&nums[low]!=elem){
                low++;
            }
            if(low>high){//cant find elem
                return high;
            }

            //found elem at low index
            while (low<=high&&nums[high]==elem){//
                high--;
            }
            if(low>high){//cant find value != elem
                return low;
            }

            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
        return low;
    }

    public int removeElement02(int[] nums,int elem){
        int idx=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=elem){
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,1,3,4,1};
        System.out.println(new RemoveElement().removeElement02(nums,1));
        System.out.println(Arrays.toString(nums));
    }

}
