package com.liu.string.easy;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liu on 17-7-6.
 */
public class KMP{

    /**
     * Implement strStr().
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
//        Pattern pattern = Pattern.compile(needle);
//        Matcher matcher = pattern.matcher(haystack);
//        matcher.find();
//        return matcher.start();
        if(needle.length()==0)
            return 0;
        int[] next = getNext(needle);
        int tlen = haystack.length();
        int plen = needle.length();
        if(tlen<plen)
            return -1;
        int i=0;
        int j=0;
        while(i<tlen&&j<plen){
            if(j==-1){
                i++;
                j=0;
            }else if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        return j==plen?i-j:-1;
    }

    public int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len];
        next[0] = -1;
        int i=0;
        int key = -1;
        while (i<len-1) {
            if (key == -1) {
                next[++i] = ++key;
            } else {
                if(needle.charAt(key)==needle.charAt(i)){
                    next[++i] = ++key;
                }else {
                    key = next[key];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] next = new KMP().getNext("abcdabcd");
        System.out.println(Arrays.toString(next));
        System.out.println(new KMP().strStr("123acbabcabcabc","abcabc"));
    }
}
