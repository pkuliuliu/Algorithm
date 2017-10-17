package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-9.
 */
public class ClimbingStairs {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

     Note: Given n will be a positive integer.
     */
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        int idx = 2;
        while(idx<=n){
            c = a+b;
            a = b;
            b = c;
            idx++;
        }
        return c;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }
}
