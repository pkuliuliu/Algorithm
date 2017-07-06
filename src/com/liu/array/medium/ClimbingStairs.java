package com.liu.array.medium;

/**
 * Created by liu on 17-6-29.
 */
public class ClimbingStairs {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    public int climbStairs(int n){
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs02(int n){
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int f1 = 1;
        int f2 = 2;
        int k=3;
        while(k<=n){
            int f3 = f1+f2;
            f1 = f2;
            f2=f3;
            k++;
        }
        return f2;
    }
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(10));
        System.out.println(new ClimbingStairs().climbStairs02(10));
    }
}
