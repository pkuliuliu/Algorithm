package com.liu.string.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-7-8.
 */
public class NextGreaterElement {
    /**
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
     * which has exactly the same digits existing in the integer n and is greater in value than n.
     * If no such positive 32-bit integer exists, you need to return -1.

     Example 1:
     Input: 12
     Output: 21
     Example 2:
     Input: 21
     Output: -1
     */
    public int nextGreaterElement(int n) {
        if(n<10){
            return -1;
        }
        char[] chars = (n+"").toCharArray();
        //find key value that less than later one from end
        int idx = chars.length-2;
        while(idx>=0){
            if(chars[idx]<chars[idx+1]){
                break;
            }
            idx--;
        }
        if(idx<0)
            return -1;
        //find the first value that biger than key value from end;
        int key = idx;
        idx = chars.length-1;
        while (idx>=0){
            if (chars[idx]>chars[key])
                break;
            idx--;
        }
        char tmp = chars[key];
        chars[key] = chars[idx];
        chars[idx] = tmp;
        Arrays.sort(chars,key+1,chars.length);
//        System.out.println(Arrays.toString(chars));
        int result = 0;
        for(char c : chars){
            if(result<10*result+(c - '0'))
                result=10*result+(c - '0');
            else
                return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(1999999999));
    }
}
