package com.liu.hiho;

import java.util.Scanner;

/**
 * Created by liu on 17-7-19.
 */
public class LongestPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        arr[0] = scanner.nextInt();
        scanner.nextLine();
        int i=2;
        while(i<=n){
            int pre=0;
            for(int j = 0; j < i; j++) {
                int num = scanner.nextInt();
                int tmp = Math.max(arr[j],pre)+num;
                pre = arr[j];
                arr[j] = tmp;
            }
            scanner.nextLine();
            i++;
        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            if(arr[j]>max)
                max = arr[j];
        }
        System.out.println(max);
    }
}
