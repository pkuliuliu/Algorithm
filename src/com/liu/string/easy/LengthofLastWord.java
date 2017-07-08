package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class LengthofLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     For example,
     Given s = "Hello World",
     return 5.
     */

    public int lengthOfLastWord(String s) {
        int cnt=0;
        int high=s.length()-1;
        char[] chars = s.toCharArray();
        while (high>=0){
            if(cnt>0&&chars[high]==' '){
                return cnt;
            }else if(chars[high]!=' '){
                cnt++;
            }
            high--;
        }
        return cnt;
    }

    public int lengthOfLastWord02(String s) {
        s = s.trim();
        return s.length()-s.lastIndexOf(' ')-1;
    }

    public static void main(String[] args) {
        int len = new LengthofLastWord().lengthOfLastWord02("world");
        System.out.println(len);
    }
}
