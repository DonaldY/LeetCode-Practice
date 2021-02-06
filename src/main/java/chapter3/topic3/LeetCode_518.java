package chapter3.topic3;

/**
 * 518. Coin Change 2
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * 题意：
 * 给一个数和一个数组，求数组里加起来等于这个数的组合数
 *
 * 思路：
 * 1. DFS
 *   f(c, i, s)
 *   求 f(c, 0, s)
 *   j: i - > n - 1
 *   res += f(c, j, s - c[j])
 *   s == 0 => 1
 *   s < 0 => 0
 *
 * 2. DP
 *    d(i) 表示的是凑齐 i 分的组合数量
 *    d(i, j) = d(i-1, j) + d(i, j - c[i-1])
 *
 */
public class LeetCode_518 {

    public int change(int amount, int[] coins) {
        return 0;
    }

    private int coinCombination(int [] coins, int start, int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        int result = 0;
        for (int i = start; i < coins.length; ++i) {
            result += coinCombination(coins, i, sum - coins[i]);
        }

        return result;
    }

    // 指数级别
    public int numberOfCoinCombinationRecursive(int sum, int[] coins) {

        return coinCombination(coins, 0, sum);
    }

    // Time: o(n * sum), Space: o(n * sum), Faster: 39.66%
    public int numberOfCoinCombinationDP(int sum, int [] coins) {

        int [][] d = new int[coins.length + 1][sum + 1];

        // base case
        for (int i = 0; i <= coins.length; ++i) d[i][0] = 1;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                int useCurCoin = j >= coins[i - 1] ? d[i][j - coins[i - 1]] : 0;
                d[i][j] = d[i - 1][j] + useCurCoin;
            }
        }
        return d[coins.length][sum];
    }

    public int numberOfCoinCombinationDP2(int sum, int [] coins) {

        int [][] dp = new int[coins.length + 1][sum + 1];

        // base case
        for (int i = 0; i <= coins.length; ++i) dp[i][0] = 1;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }

    // Time: o(n * sum), Space: o(n), Faster: 51.75%
    public int numberOfCoinCombinationDPOsum(int sum, int [] coins) {

        int [] d = new int[sum + 1];
        d[0] = 1;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                int useCurCoin = j >= coins[i - 1] ? d[j - coins[i - 1]] : 0;
                d[j] = d[j] + useCurCoin;
            }
        }
        return d[sum];
    }
    public int numberOfCoinCombinationDPOsum2(int sum, int [] coins) {

        int [] dp = new int[sum + 1];

        // base case
        dp[0] = 1;

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[sum];
    }
}
