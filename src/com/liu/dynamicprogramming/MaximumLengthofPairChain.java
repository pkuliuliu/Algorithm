package com.liu.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by liu on 17-8-9.
 */
public class MaximumLengthofPairChain {
    /**
     * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

     Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

     Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

     Example 1:
     Input: [[1,2], [2,3], [3,4]]
     Output: 2
     Explanation: The longest chain is [1,2] -> [3,4]
     Note:
     The number of given pairs will be in the range [1, 1000].
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        //sort
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0])
                    return -1;
                else if(o1[1]>o2[0])
                    return 1;
                else
                    return o1[1] - o2[1];
            }
        });
        int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j>=0; j--){
                if(pairs[j][1]<pairs[i][0]){
                    p[i] = p[i]>p[j]?p[i]:p[j]+1;
                }
            }
            max = max>p[i]?max:p[i];
        }
        return max;
    }
}
