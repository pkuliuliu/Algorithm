package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-27.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int ilen = s.length();
        int jlen = t.length();
        int i=0;
        int j=0;
        while(i<ilen&&j<jlen){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i==ilen;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("axc","ahbgdc"));
    }
}
