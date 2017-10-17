package com.liu.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-8-29.
 */
public class DistinctSubsequences {
    /**
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
     (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

     Here is an example:
     S = "rabbbit", T = "rabbit"

     Return 3.
     */
    public int numDistinct(String s, String t) {
        Map<String,Integer> map = new HashMap<>();
        return helper(map,s,t);
    }

    public int helper(Map<String,Integer> map, String s, String p){
        int s_len = s.length();
        int p_len = p.length();

        int i=0;
        while(p_len!=0&&i<s_len&&s.charAt(i)!=p.charAt(0)){
            i++;
        }
        s = s.substring(i);
        String key = s + "#" + p;
        if(map.containsKey(key)){
            return map.get(key);
        }else if(s.length()<p.length()){
            map.put(key,0);
            return 0;
        }else if(p.length()==0){
            map.put(key,1);
            return 1;
        }else if(s.charAt(0)==p.charAt(0)){
            int res = helper(map,s.substring(1),p.substring(1))+helper(map,s.substring(1),p);
            map.put(key,res);
            return res;
        }else {
            int res = helper(map,s.substring(1),p);
            map.put(key,res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("ccc","c"));
    }
}
