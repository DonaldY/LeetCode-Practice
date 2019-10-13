package chapter1.topic3;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * 题意： 股票购买, 可多次购买
 *
 * 思路：
 * 1. 只需在波谷买入，波峰卖出即可
 */
public class LeetCode_122 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int sum = 0;

        int i = 1, j = 1;

        while (i < prices.length && j < prices.length) {
            i = j;
            for (; i < prices.length; ++i) if (prices[i] > prices[i - 1]) break;

            j = i;
            for (; j < prices.length; ++j) if (prices[j] < prices[j - 1]) break;

            sum += prices[j] - prices[i - 1];
        }

        return sum;
    }

    // Time: O(n), Space: O(1), Faster: 94.50%
    public int maxProfitLocalMaxMin(int [] prices) {
        if (prices == null || prices.length == 0) return 0;

        int profit = 0, buyPrice, sellPrice;

        int i = 0, n = prices.length;

        while (i < n - 1) {
            while (i < n - 1 && prices[i + 1] <= prices[i]) ++i;
            buyPrice = prices[i];
            while (i < n - 1 && prices[i + 1] >= prices[i]) ++i;
            sellPrice = prices[i];
            profit += (sellPrice - buyPrice);
        }
        return profit;
    }

    // Time: O(n), Space: O(1), Faster: 94.50%
    public int maxProfitGreedy(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; ++i)
            if (prices[i] > prices[i-1])
                profit += (prices[i] - prices[i-1]);
        return profit;
    }
}
