package com.liu.hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liu on 17-7-19.
 */
public class KMP {
    public static int[] getNext(String pattern){
        int len = pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int i=0;
        int key = -1;
        while (i<len-1) {
            if (key == -1) {
                next[++i] = ++key;
            } else {
                if(pattern.charAt(key)==pattern.charAt(i)){
                    next[++i] = ++key;
                }else {
                    key = next[key];
                }
            }
        }
        return next;
    }

    public static int find(String str,String pattern){
        int[] next = getNext(pattern);
        int res=0;
        int i=0;
        int j=0;
        int lens = str.length();
        int lenp = pattern.length();
        if(lens<lenp)
            return 0;
        while(i<lens){
            if(j==lenp){
                res++;
                i--;
                j = next[j-1];
            }else if(j==-1 || pattern.charAt(j)==str.charAt(i)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==lenp)
            res++;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-->0){
            String pattern = scanner.nextLine();
            String str = scanner.nextLine();
            System.out.println(find(str,pattern));
        }
    }
}
