package com.liu.array.hard;

/**
 * Created by liu on 17-7-20.
 */
public class MaximumAverageSubarray {

    boolean check(int[] nums,int k,double x) //Check whether we can find a subarray whose average is bigger than x
    {
        int n=nums.length;
        double[] a=new double[n];
        for (int i=0;i<n;i++) a[i]=nums[i]-x; //Transfer to a[i], find whether there is a subarray whose sum is bigger than 0
        double now=0,last=0;
        for (int i=0;i<k;i++) now+=a[i];
        if (now>=0) return true;
        for (int i=k;i<n;i++)
        {
            now+=a[i];
            last+=a[i-k];
            if (last<0)
            {
                now-=last;
                last=0;
            }
            if (now>=0) return true;
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
        while (r-l>0.000004) //Binary search the answer
        {
            double mid=(l+r)/2;
            if (check(nums,k,mid)) l=mid; else r=mid;
        }
        return r;
    }

    public double findMaxAverage02(int[] nums,int k){
        double sum = 0.0;
        double maxavg;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        maxavg = sum/k;

        for(int i = k;i<len;i++){
            sum+=nums[i];
            double tmpsum=sum;
            double avg = tmpsum/(i+1);
            for(int j = 0;j<i-k+1;j++){
                tmpsum = tmpsum-nums[j];
                avg = avg>tmpsum/(i-j)?avg:tmpsum/(i-j);
            }
            if(avg>maxavg){
                maxavg = avg;
            }
        }
        return maxavg;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(nums.length);
        int k = 498;
        System.out.println(new MaximumAverageSubarray().findMaxAverage(nums,k));
    }
}
