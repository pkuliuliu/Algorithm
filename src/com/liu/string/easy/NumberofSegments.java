package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class NumberofSegments {
    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

     Please note that the string does not contain any non-printable characters.

     Example:

     Input: "Hello, my name is John"
     Output: 5
     */
    public int countSegments(String s) {
        s = s.trim();
        if(s.length()==0)
            return 0;
        return s.split("\\s+").length;
    }

    /**
     * 如果当前值不为空且（i==0或者前一个值为空），就表明当前字符是该segment的首字符
     * @param s
     * @return
     */
    public int countSegments02(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofSegments().countSegments("hello, my name is john"));
        System.out.println(new NumberofSegments().countSegments(""));
    }
}
