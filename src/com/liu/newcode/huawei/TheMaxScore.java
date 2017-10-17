package com.liu.newcode.huawei;

import java.util.Scanner;

/**
 * Created by liu on 17-8-22.
 */
public class TheMaxScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] line = in.nextLine().trim().split("\\s");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            String[] _nums = in.nextLine().trim().split("\\s");
            int[] nums = new int[n+1];
            for (int i = 1; i < nums.length; i++) {
                nums[i] = Integer.parseInt(_nums[i-1]);
            }

            while(m-->0){
                String[] _tmp = in.nextLine().trim().split("\\s");
                char ch = _tmp[0].charAt(0);
                int a = Integer.parseInt(_tmp[1]);
                int b = Integer.parseInt(_tmp[2]);
                if(ch=='Q'){
                    System.out.println(findMaxNumber(nums,a,b));
                }else if(ch=='U'){
                    nums[a] = b;
                }
            }
        }
    }
    static int findMaxNumber(int[] nums,int a,int b){
        int max = Integer.MIN_VALUE;
        int low = Integer.min(a,b);
        int high = Integer.max(a,b);
        for (int i = low; i < high +1; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}
