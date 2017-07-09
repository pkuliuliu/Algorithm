package com.liu.string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liu on 17-7-9.
 */
public class BasicCalculatorII {
    /**
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
     * The integer division should truncate toward zero.
     * You may assume that the given expression is always valid.

     Some examples:
     "3+2*2" = 7
     " 3/2 " = 1
     " 3+5 / 2 " = 5
     */
    /**
     * 利用栈，进行四则运算的类
     * 用两个栈来实现算符优先，一个栈用来保存需要计算的数据numStack,一个用来保存计算运算符opStack
     *
     * 基本算法实现思路为：
     * 用opStack栈顶运算符与当前取得的运算符比较优先级：
     * 若高于，则 运算 opstack栈顶操作符；
     * 若等于，则为左括号，运算符栈出栈；
     * 若小于，当前操作符入栈。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Character> opstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        s = s.replaceAll("\\s+","")+'#';
        //System.out.println(s);
        opstack.push('#');
        int i=0;
        while(i<s.length()) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int sum = cur - '0';
                i++;
                while (i<s.length()){
                    cur = s.charAt(i);
                    if(Character.isDigit(cur)){
                        sum = sum * 10 + (cur-'0');
                    }else
                        break;
                    i++;
                }
                numstack.push(sum);
            }else {
                int flag = compare(opstack,cur);
                if(flag < 0){//栈顶操作符优先级小，则新操作符入栈
                    opstack.push(cur);
                    i++;
                }else if(flag > 0){//栈顶操作符优先级大，则计算
                    int num2 = numstack.pop();
                    int num1 = numstack.pop();
                    char op = opstack.pop();
                    numstack.push(calhelper(num1,num2,op));
                }else {
                    opstack.pop();
                    i++;
                }
            }
        }
        return numstack.peek();
    }

    public int calhelper(int num1,int num2,char op){
        switch (op){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;
            default:
                return 0;
        }
    }
    public int compare(Stack<Character> opstack,Character curop){
        char c = opstack.peek();
        switch (c){
            case '*':
            case '/':
                if (curop=='(')return -1; else return 1;
            case '+':
            case '-':
                if(curop=='('||curop=='*'||curop=='/') return -1; else return 1;
            case '(':
                if(curop=='#')  return -2;else if(curop==')') return 0;else return -1;
            case ')':
                if(curop=='(') return  -2; else return 1;
            case '#':
                if(curop=='#') return 0;else if(curop==')') return -2;else return -1;
            default:
                return -1;
        }
    }


    /**
     * 仅考虑+ - * /
     * @param s
     * @return
     */
    public int calculate02(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int curNum = 0;
        int sign = 1;
        int res = 0;
        Integer prevNum = null;
        Character prevOp = null;
        for (char c : array) {
            if (c == ' ') {
                continue;
            } else if (c == '+') {
                if (prevNum != null) {
                    if (prevOp == '*') {
                        curNum *= prevNum;
                    } else {
                        curNum = prevNum / curNum;
                    }
                }
                res += curNum * sign;
                curNum = 0;
                sign = 1;
                prevNum = null;
                prevOp = null;
            } else if (c == '-') {
                if (prevNum != null) {
                    if (prevOp == '*') {
                        curNum *= prevNum;
                    } else {
                        curNum = prevNum / curNum;
                    }
                }
                res += curNum * sign;
                curNum = 0;
                sign = -1;
                prevNum = null;
                prevOp = null;
            } else if (c == '*' || c == '/') {
                if (prevNum != null) {
                    if (prevOp == '*') {
                        prevNum = prevNum * curNum;
                    } else {
                        prevNum = prevNum / curNum;
                    }
                } else {
                    prevNum = curNum;
                }
                prevOp = c;
                curNum = 0;
            } else {
                curNum = curNum * 10 + (int) (c - '0');
            }
        }
        if (prevNum != null) {
            if (prevOp == '*') {
                curNum = prevNum * curNum;
            } else {
                curNum = prevNum / curNum;
            }
        }
        res += curNum * sign;
        return res;
    }

    /**
     * 仅考虑  + - * /，使用栈
     * @param s
     * @return
     */
    public int calculate03(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len-1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int rst = 0;
        for (int i : stack) {
            rst += i;
        }
        return rst;
    }
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
