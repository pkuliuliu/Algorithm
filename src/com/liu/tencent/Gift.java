package com.liu.tencent;

/**
 * Created by liu on 17-8-29.
 */
import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        int key = gifts[0];
        int cnt = 1;
        for (int i = 1; i < gifts.length; i++) {
            if(key==gifts[i]){
                cnt++;
            }else {
                if (cnt == 0) {
                    key = gifts[i];
                    cnt = 1;
                } else {
                    cnt--;
                }
            }
        }
        cnt=0;
        for (int gift : gifts){
            if(key==gift)
                cnt++;
        }

        return cnt>n/2?key:0;
    }

    public static void main(String[] args) {
        System.out.println(new Gift().getValue(new int[]{1,2,3,3,2,2},5));
    }
}