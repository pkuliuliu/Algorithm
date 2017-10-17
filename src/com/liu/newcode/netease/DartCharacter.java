package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class DartCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1){
            System.out.println(3);
            return;
        }
        if(n==2){
            System.out.println(9);
        }
        int idx = 3;
        Long cur = 9L;
        Long same = 3L;
        Long diff = 6L;
        while(idx<=n){
            cur = same*3 + diff*2;
            same = same + diff;
            diff = cur - same;
            idx++;
        }
        System.out.println(cur);
    }
}
