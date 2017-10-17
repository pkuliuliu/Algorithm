package com.liu.newcode.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liu on 17-8-22.
 */
public class UniqueChas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            Set<Character> set = new HashSet<>();
            for(char ch : str.toCharArray()){
                if(!set.contains(ch)){
                    set.add(ch);
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
