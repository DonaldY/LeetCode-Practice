package chapter3.topic3;

/**
 * @author donald
 * @date 2021/02/02
 *
 * ### `LeetCode 516`. 最长回文子序列
 *
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *
 * ```
 * 示例 1:
 *
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 *
 *
 * 示例 2:
 *
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * ```
 *
 * 思路：
 * 1. dp
 */
public class LeetCode_516 {

    // Time: O(n ^ 2), Space: O(n ^ 2), Faster: 74.25%
    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) return 0;

        int n = s.length();

        int [][] dp = new int[n][n];

        for (int i = 0; i < n; ++i)
            dp[i][i] = 1;
        // 反向遍历保证正确的状态转移
        for (int i = n - 2; i >= 0; --i) {

            for (int j = i + 1; j < n; ++j) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        // 整个 s 的最长回文子序列长度
        return dp[0][n - 1];
    }
}
