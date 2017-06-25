package com.liu.array.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 17-6-24.
 */
public class PascalTriangleII {
    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     * For example, given k = 3,
     * Return [1,3,3,1].
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex+1];
        for (int i = 0; i < rowIndex+1; i++) {
            nums[i] = 0;
        }
        nums[0] = 1;
        for (int i = 1; i < rowIndex+1; i++) {
            for (int j = rowIndex; j > 0; j--) {
                nums[j] = nums[j]+nums[j-1];
            }
        }
        return Arrays.asList(nums);
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(4));
    }
}
