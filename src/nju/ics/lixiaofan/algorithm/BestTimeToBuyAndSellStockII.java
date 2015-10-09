package nju.ics.lixiaofan.algorithm;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
    	if(prices.length < 2)
    		return 0;
        int max = 0, buy = prices[0], sell = buy;
        for(int i = 1;i < prices.length;i++){
        	if(sell > prices[i]){
        		max += sell - buy;
        		buy = sell = prices[i];
        	}
        	else
        		sell = prices[i];
        }
        max += sell - buy;
        return max;
    }
}
