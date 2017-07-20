package com.liu.array.medium;

import java.util.Arrays;

/**
 * Created by liu on 17-7-13.
 */
public class Ali01 {
    static int min = Integer.MAX_VALUE;

    public static void getShorest(int[][] inventor,int initPoisition,int[] M, int low,int high){
        boolean flag = true;
        System.out.println(Arrays.toString(M));
        for (int i = 0; i < M.length; i++) {
            if(M[i]>0){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println("hello world !!!");
            int times = high-low + (initPoisition-low<high-initPoisition?initPoisition-low:high-initPoisition);
            min = min<times?min:times;
        }
        else {
            if(low-1>=0) {
                int[] _M1 = M.clone();
                for (int i = 0; i < _M1.length; i++) {
                    _M1[i] -= inventor[i][low-1];
                }
                getShorest(inventor,initPoisition,_M1,low-1,high);
            }
            if(high+1<M.length){
                int[] _M2 = M.clone();
                for (int i = 0; i < _M2.length; i++) {
                    _M2[i] -= inventor[i][high+1];
                }
                getShorest(inventor,initPoisition,_M2,low,high+1);
            }
        }

    }
    public static void getMin(int[][] inventor,int initPoisition,int[] M){
        for (int i = 0; i < M.length; i++) {
            M[i] = M[i]-inventor[i][initPoisition];
        }
        getShorest(inventor,initPoisition,M,initPoisition,initPoisition);
    }
    public static void main(String[] args) {
        System.out.println(min);
        getMin(new int[][]{{1,0,0,1},{1,1,0,0}},2,new int[]{1,1});
        System.out.println(min);
    }
}
