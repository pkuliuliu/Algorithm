package com.liu.jingdong;

import java.util.Scanner;

/**
 * Created by liu on 17-9-8.
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] dp = new long[100000];
        dp[1] = 1;
        dp[2] = 6;
        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine().trim());
            System.out.println(helper(dp,n));
        }
    }

    static  long helper(long[] dp,int n){
        if(dp[n] > 0)
            return dp[n];
        else {
            long res = (helper(dp,n-1)%1000000007*4+2)%1000000007;
            dp[n] = res;
            return res;
        }
    }
}
