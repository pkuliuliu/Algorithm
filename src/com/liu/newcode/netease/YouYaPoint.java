package com.liu.newcode.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-8-11.
 */
public class YouYaPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n2 = in.nextInt();
        //in.nextLine();
        if(n2<=0){
            System.out.println(0);
            return;
        }
        int radius = (int)Math.sqrt(n2);
        int cnt = 0;
        if(radius*radius==n2){
            cnt+=4;
            radius--;
        }
        while(radius>0){
            int height = (int)Math.sqrt(n2 - radius*radius);
            if(height*height+radius*radius==n2){
                cnt+=4;
            }
            radius--;
        }
        System.out.println(cnt);
        Arrays.sort(new int[]{1,2,3,4,5});
    }
}
