package com.test;

import java.util.Scanner;

/**
 * Created by liu on 17-9-18.
 */
public class Test01 {
    static boolean fun(String table,int n){
        int len = table.length();
        if(len<n){
            return false;
        }
        if(len==0){
            return false;
        }
        if(len==1&&table.charAt(0)=='0'&&n==1){
            return true;
        }
        if(len==2&&table.charAt(0)=='0'&&table.charAt(1)=='0'){
            return true;
        }
        int i=0;
        int cnt=1;
        while(i<len&&n>0){
            if(table.charAt(i)=='0'){
                cnt++;
            }else {
                cnt=0;
            }
            if(cnt==3){
                n--;
                cnt=1;
            }
            i++;
        }
        return n==0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String table = in.next();
            int n = in.nextInt();
            System.out.println(fun(table,n));
        }
    }
}
