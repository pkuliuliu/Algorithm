package com.liu.array.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 17-6-29.
 */
public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * The replacement must be in-place, do not allocate extra memory.
     * Here are some examples. Inputs are in the le-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */
    public void nextPermutation(int[] nums){
        if(nums.length<=1){
            return;
        }
        if(nums.length==2){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
        int idx = nums.length-2;//从倒数第二个值开始找，当前值比下一个值小即可调整。
        while(idx>=0){//找到要调整的开始位置
            if(nums[idx]<nums[idx+1]){
               break;
            }
            idx--;
        }
        int key = nums.length-1;
        while(key > idx){//找到开始位置之后的比开始位置的值大的最小值
            if(nums[key]>nums[idx]){
                break;
            }
            key--;
        }
        int temp = nums[idx];
        nums[idx] = nums[key];
        nums[key] = temp;
        Arrays.sort(nums,idx+1,nums.length);
//        helper(nums,0);
    }

    public boolean helper(int[] nums,int begin){
        if(begin==nums.length-2){
            if (nums[begin]<nums[begin+1]){
                int tmp = nums[begin];
                nums[begin] = nums[begin+1];
                nums[begin+1] = tmp;
                return true;
            }
            return false;
        }
        if(!helper(nums,begin+1)){//低位不能调整,说明
            if(nums[begin]>=nums[begin+1]){
                return false;
            }
            int key = nums.length-1;
            while(key > begin){//找到开始位置之后的比开始位置的值大的最小值
                if(nums[key]>nums[begin]){
                    break;
                }
                key--;
            }
            int temp = nums[begin];
            nums[begin] = nums[key];
            nums[key] = temp;
            Arrays.sort(nums,begin+1,nums.length);
            return true;
        }else
            return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,4,3,2,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
