package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class CalcCandy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * n1 = A - B,
         * n2 = B - C,
         * n3 = A + B,
         * n4 = B + C.
         */
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n4 = in.nextInt();

        int A = (n1+n3)/2;
        int B = A - n1;
        int C = B - n2;
        if((n1 == A-B) && (n2 == B-C)&&(n3 == A+B)&&(n4 == B+C)&&A>=0&&B>=0&&C>=0){
            System.out.println(A+" "+B+" "+C);
        }else
            System.out.println("No");
    }
}
