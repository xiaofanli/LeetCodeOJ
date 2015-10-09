package nju.ics.lixiaofan.algorithm;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int states[][] = {{Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0}, {0,0,0,0}}; // 0: 1 buy, 1: one buy/sell, 2: 2 buys/1 sell, 3, 2 buys/sells
        int cur = 0, next = 1;
        for(int i=0; i<prices.length; ++i){
            states[next][0] = Math.max(states[cur][0], -prices[i]);
            states[next][1] = Math.max(states[cur][1], states[cur][0]+prices[i]);
            states[next][2] = Math.max(states[cur][2], states[cur][1]-prices[i]);
            states[next][3] = Math.max(states[cur][3], states[cur][2]+prices[i]);
            cur = 1 - cur;
            next = 1 - next;
        }
        return Math.max(states[cur][1], states[cur][3]);
    }
    
}
