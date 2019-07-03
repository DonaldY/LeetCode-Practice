package chapter1.topic3;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * 题意：买卖股票，获取最大利润
 *
 * 思路：
 * 1. 更新买入价格 和 最大利润
 *    若当天价格比买入价格小，则更新买入价格
 *    若当天价格比买入价格大，则计算当天价格与买入价格之差，并与最大利润比较
 */
public class LeetCode_121 {

    // Time: o(n), Space: o(1), Faster:  87.07%
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int buyPrice = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; ++i) {

            if (buyPrice > prices[i]) buyPrice = prices[i];
            if (buyPrice < prices[i]) {

                int tempProfit = prices[i] - buyPrice;

                if (maxProfit < tempProfit) maxProfit = tempProfit;
            }
        }

        return maxProfit;
    }
}
