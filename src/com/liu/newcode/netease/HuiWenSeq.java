package com.liu.newcode.netease;

import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class HuiWenSeq {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //in.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //in.nextLine();
        if(n<2){
            System.out.println(0);
            return;
        }
        if(n==2){
            if(nums[0]==nums[1])
            {
                System.out.println(0);
            }else
                System.out.println(1);
            return;
        }
        int low = 1;
        int high = n-2;
        int sumleft = nums[0];
        int sumright = nums[n-1];
        int cnt = 0;
        while(low<high){
            if(sumleft==sumright){
                sumleft = nums[low];
                sumright = nums[high];
                low+=1;
                high-=1;
            }else if(sumleft<sumright){
                sumleft+=nums[low];
                cnt++;
                low++;
            }else {
                sumright+=nums[high];
                cnt++;
                high--;
            }
        }
        if(low==high&&sumleft!=sumright){
            if(sumleft+nums[low]==sumright||sumright+nums[low]==sumleft){
                cnt++;
            }else
                cnt+=2;
        }
        System.out.println(cnt);
    }
}
