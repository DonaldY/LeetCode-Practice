package chapter6.topic3;

/**
 * @author donald
 * @date 2021/02/01
 *
 * `LeetCode 1143`. 最长公共子序列
 *
 *
 * 给定两个字符串 `text1` 和 `text2`，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * > 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * >
 * > 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 * ```
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 *
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * ```
 *
 * 思路：
 * 1. 二维数组 dp
 * 2. dp 压缩
 */
public class LeetCode_1143 {

    // Time: O(n ^ 2), Space: O(m * n), Faster: 72.28%
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length(), n = text2.length();

        // 定义： 对于 s1[0..i-1] 和 s2[0..j-1], 它们的 lcs 长度是 dp[i][j]
        // base case: dp[0][..] = dp[..][0] = 0 已初始化
        int [][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {

            for (int j = 1; j <= n; ++j) {

                // 状态转移逻辑
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
