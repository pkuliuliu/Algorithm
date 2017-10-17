package com.liu.tencent;
import java.util.*;
/**
 * Created by liu on 17-8-29.
 */
public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        if(n==1){
            return new String[]{"0","1"};
        }else{
            String[] res = new String[(int)Math.pow(2,n)];
            String[] last = getGray(n-1);
            int i=0;
            for(String str : last){
                res[i++] = 0 + str;
            }
            for (int j = last.length-1; j >= 0; j--) {
                res[i++] = 1+last[j];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GrayCode().getGray(1)));
        System.out.println(Arrays.toString(new GrayCode().getGray(2)));
    }
}
