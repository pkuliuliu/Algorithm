package com.liu.jingdong;

import java.util.Scanner;

/**
 * Created by liu on 17-9-8.
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long n = Long.parseLong(in.nextLine().trim());
            long k = ((long)Math.sqrt(2*n));
            if(k*(k-1)<2*n&&k*(k+1)>=2*n)
                System.out.println(k);
            else
                System.out.println(k+1);
        }
    }
}
