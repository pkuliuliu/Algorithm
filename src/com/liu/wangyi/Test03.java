package com.liu.wangyi;

import java.util.Scanner;

/**
 * Created by liu on 17-9-9.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            long x[] = new long[n];
            long y[] = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = in.nextInt();
            }

            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if(x[0]==x[i]&&y[0]==y[i]){
                    continue;
                }else {
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(n);
                continue;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 2;
                    if(i==j||(x[i]==x[j]&&y[i]==y[j])){
                        continue;
                    }else if(x[i]==x[j]||y[i]==y[j]){
                        for (int k = 0; k < n; k++) {
                            if(k==i||k==j){
                                continue;
                            }else {
                                if(x[i]==x[k]||y[i]==y[k]){
                                    sum++;
                                }
                            }
                        }
                    }else {
                        long xt = x[i] - x[j];
                        long yt = y[i] - y[j];
                        for (int k = 0; k < n; k++) {
                            if(k==i||k==j){
                                continue;
                            }else {
                                if((y[k]-y[i])*(xt) == yt*(x[k]-x[i])||(y[k]-y[i])*yt==-(xt)*(x[k]-x[i])){
                                    sum++;
                                }
                            }
                        }
                    }
                    res = res>sum?res:sum;

                    sum=2;
                    if(x[i]==x[j]){
                        for (int k = 0; k < n; k++) {
                            if(k==i||k==j){
                                continue;
                            }else {
                                if(x[i]==x[k]){
                                    sum++;
                                }else {

                                }
                            }
                        }
                    }else {
                        long xt = x[i] - x[j];
                        long yt = y[i] - y[j];
                        for (int k = 0; k < n; k++) {
                            if(k==i||k==j){
                                continue;
                            }else {
                                if((y[k]-y[i])*(xt) == yt*(x[k]-x[i])||(y[k]-y[i])*yt==-(xt)*(x[k]-x[i])){
                                    sum++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
