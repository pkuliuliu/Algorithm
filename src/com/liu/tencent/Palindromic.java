package com.liu.tencent;
import java.util.*;
/**
 * Created by liu on 17-8-29.
 */
public class Palindromic {
    public static int helper(int[][] dp,String str,int low,int high){
        if(low>high)
            return 0;
        int res = 0;
        if(dp[low][high]!=-1){
            return dp[low][high];
        }
        if(low==high){
            res = 1;
        }else if(str.charAt(low)==str.charAt(high)){
            res = helper(dp,str,low+1,high-1)+2;
        }else{
            res = Math.max(helper(dp,str,low+1,high),helper(dp,str,low,high-1));
        }
        dp[low][high]=res;
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            int len = str.length();
            if(len<2){
                System.out.println(0);
                continue;
            }
            int[][] dp = new int[len][len];
            for (int i= 0;i<len;i++){
                Arrays.fill(dp[i],-1);
            }
            System.out.println(len-helper(dp,str,0,len-1));
        }
    }
}
