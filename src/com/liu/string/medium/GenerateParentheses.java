package com.liu.string.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liu on 17-7-8.
 */
public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     */

    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        if(n==0){
            return new ArrayList<>(result);
        }

        result.add("()");
        int i=1;
        while(i<n){
            Set<String> tmp = new HashSet<>(result);
            result.clear();
            for(String elem :tmp){
                int len = elem.length();
                result.add("()"+elem);
                for (int j = 0; j < len-1; j++) {
                    result.add(elem.substring(0,j+1)+"()"+elem.substring(j+1,len));
                }
                result.add(elem+"()");
            }
            i++;
        }
        return new ArrayList<>(result);
    }


    private void helper(List<String> res, int left, int right, String cur) {
        if (left == 0 && right == 0) {
            System.out.println(cur);
            res.add(cur);
            return;
        }
        if (left > 0) {//增加一个 “(”
            helper(res, left - 1, right, cur + "(");
        }
        if (right > left) {//随后增加一个“)”保持开闭稳定
            helper(res, left, right - 1, cur + ")");
        }

    }
    public List<String> generateParenthesis02(int n) {
        List<String> res = new ArrayList<> ();
        if (n < 1) return res;
        helper(res, n, n, "");
        return res;
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis02(3);
        System.out.println(result);
    }
}
