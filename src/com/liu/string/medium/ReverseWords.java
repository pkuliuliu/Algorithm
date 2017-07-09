package com.liu.string.medium;

/**
 * Created by liu on 17-7-9.
 */
public class ReverseWords {
    /**
     * Given an input string, reverse the string word by word.

     For example,
     Given s = "the sky is blue",
     return "blue is sky the".
     */
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length()==0){
            return s;
        }
        int i =0;
        int len = s.length();
        char[] chars = s.toCharArray();

        String result="";
        String tmp="";
        while (i<len){
            if(chars[i]!=' '){
                tmp+=chars[i];
            }else{
                result = (tmp==""?"":tmp+" ")+result;
                tmp="";
            }
            i++;
        }
        result = (tmp==""?"":tmp+" ")+result;
        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }
}
