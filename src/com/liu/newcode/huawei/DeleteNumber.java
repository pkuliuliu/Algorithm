package com.liu.newcode.huawei;

import java.util.Scanner;

/**
 * Created by liu on 17-8-22.
 */
public class DeleteNumber {
    /**
     * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
     * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n>1000)
                n=1000;
            int[] nums = new int[n];
            int idx = n-1;
            for (int i = 0; i < n; i++) {
                int cnt=0;
                while(cnt<3){
                    idx = (idx+1)%n;
                    if(nums[idx]==0){
                        cnt++;
                    }
                }
                nums[idx]=-1;
            }
            System.out.println(idx);
        }
    }
}
