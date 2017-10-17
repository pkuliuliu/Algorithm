package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class TiaoShiBan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] dp = new int[M+M/2+1];
        dp[N] = 0;
        for(int i = 2;i<=N/2;i++) {
            if(N%i==0){
                dp[N+N/i] = 1;
            }
        }
        int idx = N+1;
        while(idx<=M){
            if(dp[idx]!=0){
                for(int i = 2;i<=Math.sqrt(idx);i++) {
                    if(idx%i==0){
                        if(dp[idx+idx/i]==0)
                            dp[idx+idx/i] = dp[idx]+1;
                        else
                            dp[idx+idx/i] = Math.min(dp[idx+idx/i],dp[idx]+1);
                        if(i==idx/i){
                            continue;
                        }
                        if(dp[idx+i]==0)
                            dp[idx+i] = dp[idx]+1;
                        else
                            dp[idx+i] = Math.min(dp[idx+i],dp[idx]+1);
                    }
                }
            }
            idx++;
        }
        System.out.println(dp[M]);
    }
}
