package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-9-21.
 */
public class Test02 {
    static int res;
    static int helper(int[][] dp,int[][] nums,int idx_x,int idx_y,int x,int y){
        if(idx_x<0||idx_x>=x||idx_y<0||idx_y>=y){
            return 0;
        }else if (dp[idx_x][idx_y]!=-1){
            return dp[idx_x][idx_y];
        }else {
            int tmp=0;
            if(idx_y-1>=0&&nums[idx_x][idx_y-1]<nums[idx_x][idx_y]){
                int left = helper(dp,nums,idx_x,idx_y-1,x,y);
                tmp = tmp>left?tmp:left;
            }
            if(idx_y+1<y&&nums[idx_x][idx_y+1]<nums[idx_x][idx_y]){
                int right = helper(dp,nums,idx_x,idx_y+1,x,y);
                tmp = tmp>right?tmp:right;
            }
            if(idx_x-1>=0&&nums[idx_x-1][idx_y]<nums[idx_x][idx_y]){
                int up = helper(dp,nums,idx_x-1,idx_y,x,y);
                tmp = tmp>up?tmp:up;
            }
            if(idx_x+1<x&&nums[idx_x+1][idx_y]<nums[idx_x][idx_y]){
                int down = helper(dp,nums,idx_x+1,idx_y,x,y);
                tmp = tmp>down?tmp:down;
            }
            dp[idx_x][idx_y]=tmp + 1;
            res = res>tmp?res:tmp + 1;

            if(idx_y-1>=0&&nums[idx_x][idx_y-1]>=nums[idx_x][idx_y]){
                helper(dp,nums,idx_x,idx_y-1,x,y);
            }
            if(idx_y+1<y&&nums[idx_x][idx_y+1]>=nums[idx_x][idx_y]){
                helper(dp,nums,idx_x,idx_y+1,x,y);
            }
            if(idx_x-1>=0&&nums[idx_x-1][idx_y]>=nums[idx_x][idx_y]){
                helper(dp,nums,idx_x-1,idx_y,x,y);
            }
            if(idx_x+1<x&&nums[idx_x+1][idx_y]>=nums[idx_x][idx_y]){
                helper(dp,nums,idx_x+1,idx_y,x,y);
            }
            return tmp+1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            int[][] nums = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
            int[][] dp=new int[x][y];
            for (int i = 0; i < x; i++) {
                Arrays.fill(dp[i],-1);
            }
            res=0;
            helper(dp,nums,0,0,x,y);
            System.out.println(res);
        }
    }
}
