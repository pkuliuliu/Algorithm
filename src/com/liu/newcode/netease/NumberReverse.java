package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class NumberReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int _x = 0;
        while(x!=0){
            _x = _x*10 + x%10;
            x = x/10;
        }
        int _y = 0;
        while(y!=0){
            _y = _y*10 + y%10;
            y = y/10;
        }

        int z = _x+_y;
        int res = 0;
        while (z!=0){
            res = res*10 + z%10;
            z = z/10;
        }

        System.out.println(res);
    }
}
