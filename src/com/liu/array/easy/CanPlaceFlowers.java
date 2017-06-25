package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-25.
 */
public class CanPlaceFlowers {

    /**
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
     * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
     * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     *  Example 1:
            Input: flowerbed = [1,0,0,0,1], n = 1
            Output: True

        Example 2:
            Input: flowerbed = [1,0,0,0,1], n = 2
            Output: False
     * @param flowerbed
     * @param n
     * @return
     */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n<=0)
            return true;
        int cnt=0;
        int len = flowerbed.length;
        if(len==0){
            return false;
        }
        if(len==1){
            return flowerbed[0]==0;
        }

        if(flowerbed[0]==0&&flowerbed[1]==0) {
            flowerbed[0]=1;
            cnt++;
        }
        for (int i = 1; i < len-1; i++) {
            if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                cnt++;
            }
        }
        if(flowerbed[len-1]==0&&flowerbed[len-2]==0){
            flowerbed[len-1]=1;
            cnt++;
        }
        return cnt>=n;
    }

    public boolean canPlaceFlowers02(int[] flowerbed, int n) {
        int num_flowers = 0, prev = 0, next = 0;
        for ( int i = 0; i < flowerbed.length; i++ ) {
            if ( i == flowerbed.length - 1 ) next = 0;
            else next = flowerbed[i+1];
            if ( i > 0 ) prev = flowerbed[i-1];
            if ( prev == 0 && next == 0 && flowerbed[i] == 0 ) {
                flowerbed[i] = 1;
                num_flowers++;
            }
        }
        return num_flowers >= n;
    }

    public static void main(String[] args) {
        int[] flowers = new int[]{1,0,1,0,1,0,1};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowers,2));
        System.out.println(Arrays.toString(flowers));
    }
}
