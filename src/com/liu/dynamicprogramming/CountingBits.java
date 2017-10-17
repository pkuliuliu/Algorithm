package com.liu.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by liu on 17-8-28.
 */
public class CountingBits {
    /**
     * Given a non negative integer number num.
     * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

     Example:
     For num = 5 you should return [0,1,1,2,1,2].

     Follow up:

     It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
     Space complexity should be O(n).
     Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
     */

    public int[] countBits(int num) {
        if(num==0)
            return new int[1];
        if(num==1){
            return new int[]{0,1};
        }
        int cur = 2;
        int[] dp = new int[num+1];
        dp[1] = 1;
        for (int i = 1; cur < num+1; i++) {
            dp[cur++] = dp[i]+0;
            if(cur<num+1)
                dp[cur++] = dp[i]+1;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }
}
