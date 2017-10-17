package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class MaxOddDivisor {

    static int f(int i){
        while(i%2==0){
            i = i/2;
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long sum = 0;
        for (int i = 1; i < N + 1; i++) {
            if(i%2!=0){
                sum+=i;
            }else {
                sum+=f(i);
            }
        }
        System.out.println(sum);
    }
}
