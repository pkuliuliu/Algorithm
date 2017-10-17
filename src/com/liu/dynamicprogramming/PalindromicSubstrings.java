package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-10.
 */
public class PalindromicSubstrings {
    /**
     * Given a string, your task is to count how many palindromic substrings in this string.
     *
     * The substrings with different start indexes or end indexes are counted as different substrings even
     * they consist of same characters.

     Example 1:
     Input: "abc"
     Output: 3
     Explanation: Three palindromic strings: "a", "b", "c".
     Example 2:
     Input: "aaa"
     Output: 6
     Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

     */
    /**
     * 对于每个点，以其为中心点扩散，同样的，以该点和其之后的点为中心
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        if(len==0)
            return 0;
        int sum = len;
        for (int i = 0; i < len-1; i++) {
            int begin = i-1;
            int end = i+1;
            while(begin>=0&&end<len){
                if(s.charAt(begin)==s.charAt(end)){
                    sum++;
                    begin--;
                    end++;
                }else {
                    break;
                }
            }
            begin = i;
            end = i+1;
            while(begin>=0&&end<len){
                if(s.charAt(begin)==s.charAt(end)){
                    sum++;
                    begin--;
                    end++;
                }else
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("abc"));
        System.out.println(ps.countSubstrings("aaa"));
    }
}
