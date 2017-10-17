package com.liu.newcode.huawei;

import java.util.Scanner;

/**
 * Created by liu on 17-8-22.
 */
public class ConversionOfNumberSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String value = in.next().substring(2);
            System.out.println(Integer.parseInt(value, 16));
        }
    }
}
