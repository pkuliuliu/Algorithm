package com.liu.newcode.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by liu on 17-8-22.
 */
public class WenJuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Set<Integer> set = new TreeSet<>();
            while(n-->0){
                set.add(in.nextInt());
            }
            for (Integer i : set){
                System.out.println(i);
            }
        }
    }
}
