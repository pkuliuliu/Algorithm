package com.liu.array.easy;

/**
 * Created by liu on 17-6-24.
 */
public class BestTimetoBuyandSellStockII {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
     * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public int maxProfit(int[] prices) {
        int result=0;
        for(int i=0;i<prices.length-1;i++){
            result+=prices[i]<prices[i+1]?prices[i+1]-prices[i]:0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(new int[]{1,3,5,4,2,1,6}));
    }
}
