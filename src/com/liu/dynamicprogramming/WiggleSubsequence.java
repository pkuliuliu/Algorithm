package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-27.
 */
public class WiggleSubsequence {

    /**
     * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
     * The first difference (if one exists) may be either positive or negative.
     * A sequence with fewer than two elements is trivially a wiggle sequence.
     *
     * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
     * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
     * the first because its first two differences are positive and the second because its last difference is zero.

     Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
     A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

     Examples:
     Input: [1,7,4,9,2,5]
     Output: 6
     The entire sequence is a wiggle sequence.

     Input: [1,17,5,10,13,15,10,5,16,8]
     Output: 7
     There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

     Input: [1,2,3,4,5,6,7,8,9]
     Output: 2
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return len;

        int d = nums[1]-nums[0];
        int cnt = 1;

        int i=1;
        if(d!=0){
            cnt++;
        }else {
            while(i<len){
                d = nums[i]-nums[i-1];
                if(d!=0){
                    cnt++;
                    break;
                }
                i++;
            }
        }
        while(i<len){
            int tmp = nums[i]-nums[i-1];
            if(d*tmp<0){
                cnt++;
                d = tmp;
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{3,3,3,2,5}));
    }
}
