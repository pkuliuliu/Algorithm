package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class ReverseVowels {
    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     Example 1:
     Given s = "hello", return "holle".
     Example 2:
     Given s = "leetcode", return "leotcede".
     Note:
     The vowels does not include the letter "y".
     */

    public String reverseVowels(String s) {
        int low=0;
        int high = s.length()-1;
        char[] chars = s.toCharArray();
        while (low<high){
            while (low<high){
                if(-1=="aeiouAEIOU".indexOf(chars[low])){
                    low++;
                }else
                    break;
            }
            while (low<high){
                if(-1=="aeiouAEIOU".indexOf(chars[high])){
                    high--;
                }else {
                    break;
                }
            }
            if(low<high){
                char tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
        System.out.println(new ReverseVowels().reverseVowels("leetcode"));
    }
}
