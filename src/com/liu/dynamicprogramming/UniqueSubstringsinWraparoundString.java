package com.liu.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by liu on 17-8-18.
 */
public class UniqueSubstringsinWraparoundString {
    /**
     * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
     * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

     Now we have another string p.
     Your job is to find out how many unique non-empty substrings of p are present in s.
     In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

     Note: p consists of only lowercase English letters and the size of p might be over 10000.

     Example 1:
     Input: "a"
     Output: 1

     Explanation: Only the substring "a" of string "a" is in the string s.
     */

    /**
     * After failed with pure math solution and time out with DFS solution, I finally realized that this is a DP problem...
     The idea is, if we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z', then the summary of them is the answer. Why is that?

     The max number of unique substring ends with a letter equals to the length of max contiguous substring ends with that letter. Example "abcd", the max number of unique substring ends with 'd' is 4, apparently they are "abcd", "bcd", "cd" and "d".
     If there are overlapping, we only need to consider the longest one because it covers all the possible substrings. Example: "abcdbcd", the max number of unique substring ends with 'd' is 4 and all substrings formed by the 2nd "bcd" part are covered in the 4 substrings already.
     No matter how long is a contiguous substring in p, it is in s since s has infinite length.
     Now we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z' and those substrings are all in s. Summary is the answer, according to the question.
     *
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int len = p.length();
        int[] count = new int[26];
        int cnt = 1;
        count[p.charAt(0)-'a'] = 1;
        for (int i = 1; i < len; i++) {
            if((p.charAt(i-1)+1==p.charAt(i))||(p.charAt(i-1)=='z'&&p.charAt(i)=='a')){
                cnt++;
            }else {
                cnt=1;
            }
            count[p.charAt(i)-'a'] = Math.max(count[p.charAt(i)-'a'],cnt);
        }
//        System.out.println(Arrays.toString(count));
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum+=count[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        UniqueSubstringsinWraparoundString u = new UniqueSubstringsinWraparoundString();
        System.out.println(u.findSubstringInWraproundString("zab"));
    }
}
