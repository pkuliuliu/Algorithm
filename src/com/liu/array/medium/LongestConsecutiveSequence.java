package com.liu.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liu on 17-6-29.
 */
public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * For example, Given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence is [1,2, 3, 4].
     * Return its length: 4.
     * Your algorithm should run in O(n) complexity
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }

    /**
     * 记录每个值到目前位置能够连到一起的数的数量，，并更新序列两头的数量值，因为最远处的数还会被用来计算新值
     * @param nums
     * @return
     */
    public int longestConsecutive02(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) continue;//已经计算过的索引不再使用。。每个值只有一次使用机会
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;
            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);//更新两端的索引的值，中间到已经没有意义了，
            m.put(num + right, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{1,2,0,1}));
    }
}
