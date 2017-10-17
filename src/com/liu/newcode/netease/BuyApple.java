package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class BuyApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<6){
            System.out.println(-1);
            return;
        }
        int sum = 0;
        if(n==6||n==8){
            System.out.println(1);
            return;
        }
        if(n<12){
            System.out.println(-1);
            return;
        }
        int[] dp = new int[n+1];
        dp[6] = 1;
        dp[8] = 1;
        int idx = 12;
        while(idx<=n){
            if(dp[idx-6]!=0){
                dp[idx] = dp[idx-6]+1;
            }
            if(dp[idx-8]!=0){
                if(dp[idx]==0){
                    dp[idx] = dp[idx-8]+1;
                }else{
                    dp[idx] = Math.min(dp[idx],dp[idx-8]+1);
                }
            }
            idx++;
        }
        System.out.println(dp[n]==0?-1:dp[n]);
    }
}
