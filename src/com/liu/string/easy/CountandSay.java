package com.liu.string.easy;

/**
 * Created by liu on 17-7-8.
 */
public class CountandSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth term of the count-and-say sequence.

     Note: Each term of the sequence of integers will be represented as a string.

     Example 1:

     Input: 1
     Output: "1"
     Example 2:

     Input: 4
     Output: "1211"
     */

    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String s = countAndSay(n-1);
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        char key=chars[0];
        int cnt=1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]!=key){
                result.append(cnt);
                result.append(key);
                key = chars[i];
                cnt=1;
            }else {
                cnt++;
            }
        }
        result.append(cnt);
        result.append(key);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountandSay().countAndSay(2).toString());
        System.out.println(new CountandSay().countAndSay(4).toString());
        System.out.println(new CountandSay().countAndSay(5).toString());
    }
}
