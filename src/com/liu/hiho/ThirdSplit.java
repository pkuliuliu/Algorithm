package com.liu.hiho;

import java.util.Scanner;

/**
 * Created by liu on 17-7-19.
 */
public class ThirdSplit {
    static int thirdSplit(int[] nums,int left,int right,int suml,int sumr,int sum){
        if(left+1>=right)
            return 0;
        int summ = sum-suml-sumr;
        int res=0;
        if(Math.abs(suml-summ)<=1&&Math.abs(summ-sumr)<=1&&Math.abs(suml-sumr)<=1){
            res+=1;
        }
        if(left+2<right){
            int tmp = sum/3;
            int _suml = suml;
            int _left = left+1;
            while(_left<right-1){
                _suml+=nums[_left];
                if(_suml==tmp||_suml-1==tmp){
                    res+=thirdSplit(nums,_left,right,_suml,sumr,sum);
                    break;
                }
                _left++;
            }
            int _sumr = sumr;
            int _right = right-1;
            while (_right>left+1) {
                _sumr+=nums[_right];
                if(_sumr==tmp||_sumr-1==tmp) {
                    res += thirdSplit(nums, left, _right, suml, _sumr, sum);
                    break;
                }
                _right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        int sum = 0;
        int i=0;
        while(i<n){
            nums[i] = scanner.nextInt();
            sum+=nums[i];
            i++;
        }
        scanner.nextLine();
        int suml = 0;
        int sumr = 0;

        int tmp = sum/3;
        int left = 0;
        while(left<n){
            suml+=nums[left];
            if(suml==tmp||suml-1==tmp){
                break;
            }
            left++;
        }

        int right = n-1;
        while(right>0){
            sumr+=nums[right];
            if(sumr==tmp||sumr-1==tmp){
                break;
            }
            right--;
        }
        if(left+1>=right){
            System.out.println(0);
        }else
            System.out.println(thirdSplit(nums,0,n-1,suml,sumr,sum));
    }
}
