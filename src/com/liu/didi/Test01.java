package com.liu.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-8-26.
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] tmp = in.nextLine().trim().split("\\s");
            int[] nums = new int[tmp.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(tmp[i]);
            }
            Arrays.sort(nums);
            int k = Integer.parseInt(in.nextLine().trim());
            System.out.println(nums[nums.length - k]);
        }
    }
}
