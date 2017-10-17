package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-9.
 */
public class BestTimetoBuyandSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     */
    /**
     * Input: [7, 1, 5, 3, 6, 4]
     Output: 5

     max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     */
    /**
     * Input: [7, 6, 4, 3, 1]
     Output: 0

     In this case, no transaction is done, i.e. max profit = 0.

     */

    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len<=1){
            return 0;
        }
        int minValue = prices[0];
        int maxRes = 0;
        int idx = 1;
        while(idx<len){
            maxRes = Math.max(maxRes,prices[idx] - minValue);
            minValue = Math.min(minValue,prices[idx]);
            idx++;
        }
        return maxRes;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bestTimetoBuyandSellStock.maxProfit(nums));
    }
}
