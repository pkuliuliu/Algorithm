package com.liu.tencent;
import java.util.*;

/**
 * Created by liu on 17-8-29.
 */
public class InterestingNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = Integer.parseInt(in.nextLine().trim());
            if(len<2)
                System.out.println(0+" "+0);
            String[] strs = in.nextLine().trim().split("\\s");
            int[] nums = new int[len];
            for(int i=0;i<len;i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(nums);
            int min = nums[0];
            int max = nums[len-1];
            if(min==max){
                System.out.println(len*(len-1)/2+" "+len*(len-1)/2);
                continue;
            }
            int min_cnt = 1;
            int max_cnt = 1;
            int i = 1;
            while(i<len){
                if(nums[i]==min){
                    min_cnt++;
                }else {
                    break;
                }
                i++;
            }
            int j = len-2;
            while(j>=i){
                if(nums[j]==max){
                    max_cnt++;
                }else
                    break;
                j--;
            }
            if(min_cnt==1){
                int min_2 = nums[1];
                int min_2_cnt = 1;
                int k=2;
                while(k<len){
                    if(nums[k]==min_2){
                        min_2_cnt++;
                    }else {
                        break;
                    }
                    k++;
                }
                System.out.print(min_cnt*min_2_cnt+" ");
            }else {
                System.out.print(min_cnt*(min_cnt-1)/2+" ");
            }
            System.out.println(max_cnt*min_cnt);
        }
    }
}
