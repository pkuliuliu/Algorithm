package com.liu.array.easy;

/**
 * Created by liu on 17-6-24.
 */
public class BestTimetoBuyandSellStock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * @param prices
     * 解法：用当前值减去之前的最小值。。。表示每个时间点卖出的最大收益
     */
    public int maxProfit(int[] prices){
        if(prices.length<2){
            return 0;
        }
        int mix = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = result>prices[i]-mix?result:prices[i]-mix;
            mix = mix<prices[i]?mix:prices[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
