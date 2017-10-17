package com.liu.newcode.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-8-12.
 */
public class DuiQizi {
    static int[] helper(int[][] pos,int x,int y,int n){
        int[] res = new int[n];
        int idx = 0;
        while(idx<n){
            res[idx] = Math.abs(x-pos[0][idx])+Math.abs(y-pos[1][idx]);
            idx++;
        }
        Arrays.sort(res);
        //System.out.println(Arrays.toString(res));
        for(int i = 1;i<n;i++){
            res[i]+=res[i-1];
        }
        //System.out.println("x:"+x+" y"+y+" "+Arrays.toString(res));
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        int[][] pos = new int[2][n];
        for (int i = 0; i < n; i++) {
            pos[0][i] = in.nextInt();
            x_min = x_min<pos[0][i]?x_min:pos[0][i];
            x_max = x_max>pos[0][i]?x_max:pos[0][i];
        }
        for (int i = 0; i < n; i++) {
            pos[1][i] = in.nextInt();
            y_min = y_min<pos[1][i]?y_min:pos[1][i];
            y_max = y_max>pos[1][i]?y_max:pos[1][i];
        }
        for (int i = 0; i < n; i++) {
            pos[0][i] = pos[0][i] - x_min;
            pos[1][i] = pos[1][i] - y_min;
        }
        x_max = x_max - x_min;
        y_max = y_max - y_min;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        //System.out.println(Arrays.toString(pos[0]));
        //System.out.println(Arrays.toString(pos[1]));
        for(int i=0;i<=x_max;i++){
            for(int j=0;j<=y_max;j++){
                int tmp[] = helper(pos,i,j,n);
                for(int k = 0;k<n;k++){
                    res[k] = res[k]<tmp[k]?res[k]:tmp[k];
                }
            }
        }

        System.out.print(res[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" "+res[i]);
        }
        System.out.println();
    }
}
