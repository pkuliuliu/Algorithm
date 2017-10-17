package com.liu.newcode.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-8-12.
 */
public class DengChaShuLie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        if(n<2){
            System.out.println("Impossible");
            return;
        }
        Arrays.sort(x);
        int d = x[1] - x[0];
        for(int i=2 ;i<n;i++){
            if(x[i]-x[i-1]!=d){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

}
