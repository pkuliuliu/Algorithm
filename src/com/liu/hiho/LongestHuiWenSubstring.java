package com.liu.hiho;

/**
 * Created by liu on 17-7-19.
 */
import java.util.Scanner;
public class LongestHuiWenSubstring{
    static int find(String str){
        int len = str.length();
        if(len<=1){
            return len;
        }
        int min=1;
        for(int i=0;i<len-1;i++){
            if(2*(len-1-i<i+1?len-i-1:i+1)>min){
                int v1 = helper(str,i,i+1);
                min = min>v1?min:v1;
            }
            if(2*(len-i-1<i?len-i-1:i)+1>min){
                int v2 = helper(str,i,i);
                min = min>v2?min:v2;
            }
        }
        return min;
    }
    static int helper(String str,int low,int high){
        int len = str.length();
        while(low>=0&&high<len&&str.charAt(low)==str.charAt(high)){
            low--;
            high++;
        }
        return high - low - 1;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        while(m-->0)
            System.out.println(find(scanner.nextLine()));
    }
}