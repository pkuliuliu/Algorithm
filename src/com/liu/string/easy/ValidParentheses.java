package com.liu.string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by liu on 17-7-7.
 */
public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(stack.empty()||map.get(stack.pop())!=s.charAt(i)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * 使用数组当做栈======good idea
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length + 1];
        stack[0] = '-';
        int p = 1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch(c) {
                case '(':
                    stack[p++] = ')';
                    break;
                case '[':
                    stack[p++] = ']';
                    break;
                case '{':
                    stack[p++] = '}';
                    break;
                default:
                    if (stack[--p] != c) return false;
            }
        }
        return p == 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(){}[]"));
        System.out.println(new ValidParentheses().isValid("([)]"));
        System.out.println(new ValidParentheses().isValid("(((){}[]"));
    }
}
