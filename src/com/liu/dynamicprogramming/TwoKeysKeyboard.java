package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-23.
 */
public class TwoKeysKeyboard {
    /**
     * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

     Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
     Paste: You can paste the characters which are copied last time.
     Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

     Example 1:
     Input: 3
     Output: 3
     Explanation:
     Intitally, we have one character 'A'.
     In step 1, we use Copy All operation.
     In step 2, we use Paste operation to get 'AA'.
     In step 3, we use Paste operation to get 'AAA'.
     */

    public int minSteps(int n) {
        int[] nums = new int[n+1];
        return helper(n,nums);
    }
    public int helper(int n,int[] nums){
        if(n==1)
            return 0;
        if(n==2)
            return 2;
        if(nums[n]>0){
            return nums[n];
        }
        int m = (int)Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if(n%i==0){
                int res = minSteps(n/i)+ i;
                nums[n] = res;
                return res;
            }
        }
        nums[n] = n;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(12));
    }
}
