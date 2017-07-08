package com.liu.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-7-8.
 */
public class RansomNote {
    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines,
     * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     * Each letter in the magazine string can only be used once in your ransom note.

     Note:
     You may assume that both strings contain only lowercase letters.

     canConstruct("a", "b") -> false
     canConstruct("aa", "ab") -> false
     canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> rmap = new HashMap<>();
        Map<Character,Integer> mmap = new HashMap<>();
        for(char c : ransomNote.toCharArray()){
            rmap.put(c,rmap.getOrDefault(c,0)+1);
        }
        for(char c : magazine.toCharArray()){
            mmap.put(c,mmap.getOrDefault(c,0)+1);
        }
        for(Character key : rmap.keySet()){
            if(rmap.get(key)>mmap.getOrDefault(key,0)){
                return false;
            }
        }
        return true;
    }

    /**
     * 使用长度为26的一维数组计数！！！
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct02(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] construct = new int[26];
        for(char m : mag){
            construct[m - 'a']++;
        }
        for(char r : ransom){
            construct[r - 'a']--;
            if(construct[r - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a","b"));
        System.out.println(new RansomNote().canConstruct("aa","ab"));
        System.out.println(new RansomNote().canConstruct("aa","aab"));
    }
}
