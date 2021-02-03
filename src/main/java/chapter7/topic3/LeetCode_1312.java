package chapter7.topic3;

/**
 * @author donald
 * @date 2021/02/03
 *
 * `LeetCode 1312`. 让字符串成为回文串的最少插入次数
 *
 * 给你一个字符串 `s` ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 `s` 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 *
 * ```
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 *
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 *
 * 输入：s = "no"
 * 输出：1
 * ```
 *
 * 提示：
 *
 * > 1 <= `s.length` <= 500
 * > `s` 中所有字符都是小写字母。
 *
 * 思路：
 * 1. dp
 */
public class LeetCode_1312 {

    // Time: O(n ^ 2), Space: O(n ^ 2), Faster: 60.65%
    public int minInsertions(String s) {
        int n = s.length();

        // 定义： 对 s[i..j], 最少需要插入 dp[i][j] 次才能变成回文串
        // base case： dp 数组全部初始化为 0
        int [][] dp = new int[n][n];

        // 从下向上遍历
        for (int i = n - 2; i >= 0; --i) {
            // 从左向右遍历
            for (int j = i + 1; j < n; ++j) {
                // 根据 s[i] 和 s[j] 进行状态转移
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j -1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        // 根据 dp 数组的定义，题目要求的答案是 dp[0][n - 1]
        return dp[0][n - 1];
    }
}
