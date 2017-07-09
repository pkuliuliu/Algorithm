package com.liu.string.medium;

import java.util.*;

/**
 * Created by liu on 17-7-8.
 */
public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.

     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:

     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     Note: All inputs will be in lower-case.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null || strs.length==0)
            return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = Arrays.toString(chars);
            if(map.containsKey(tmp))
                map.get(tmp).add(str);
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
