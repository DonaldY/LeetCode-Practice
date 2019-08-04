package chapter2.topic3;

/**
 * 322. Coin Change
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * 题意： 这个题目说的是，给你一些面值不同的硬币，每一种面值的硬币都有无限多个，现在你要用这些硬币组成一个给定的数值，
 * 那么请问，最少需要多少个硬币。另外，如果给你的面值无法组成给定数值，就返回 -1。
 *
 * 思路：
 * 1. DP
 */
public class LeetCode_322 {

    public int coinChange(int[] coins, int amount) {

        return -1;
    }

    // Time: o(n * sum), Space: o(n * sum), Faster: 55.30%
    public int minCoinCombination(int [] coins, int amount) {

        int [][] d = new int[coins.length + 1][amount + 1];
        for (int j = 1; j <= amount; ++j) {
            d[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {
                int useCurCoin = j >= coins[i - 1] ? d[i][j - coins[i - 1]] : Integer.MAX_VALUE;
                if (useCurCoin != Integer.MAX_VALUE) useCurCoin += 1;
                d[i][j] = Math.min(d[i - 1][j], useCurCoin);
            }
        }
        return d[coins.length][amount] == Integer.MAX_VALUE ? -1 : d[coins.length][amount];
    }

    // Time: O(n*sum), Space: O(sum)
    public int minCoinCombinationOsum(int[] coins, int sum) {
        int[] d = new int[sum+1];
        for (int j = 1; j <= sum; ++j)
            d[j] = Integer.MAX_VALUE;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = coins[i-1]; j <= sum; ++j) {
                if (d[j-coins[i-1]] != Integer.MAX_VALUE) {
                    d[j] = Math.min(d[j], d[j-coins[i-1]] + 1);
                }
            }
        }
        return d[sum] == Integer.MAX_VALUE ? -1 : d[sum];
    }
}
