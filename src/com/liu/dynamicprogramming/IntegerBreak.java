package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-9.
 */
public class IntegerBreak {
    /**
     * Given a positive integer n,
     * break it into the sum of at least two positive integers and maximize the product of those integers.
     * Return the maximum product you can get.
     * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
     * Note: You may assume that n is not less than 2 and not larger than 58.
     */
    public int integerBreak(int n) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int numbersOf3 = n/3;
        if(n%3==1)
            return (int)Math.pow(3,numbersOf3-1)*4;
        if(n%3==2)
            return (int)Math.pow(3,numbersOf3)*2;
        return (int)Math.pow(3,numbersOf3);
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(2));
        System.out.println(ib.integerBreak(10));
        System.out.println(ib.integerBreak(58));
    }
}
