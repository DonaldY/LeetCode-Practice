package chapter1.topic3;

import java.util.Arrays;

/**
 * @author donald
 * @date 2021/03/17
 *
 * LeetCode 115. 不同的子序列
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *
 * ```
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 *
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 * ```
 *
 * 题意：
 *
 *
 * 思路：
 * 1. 暴力法： dfs 搜索，可优化（减枝、记忆）
 * 2. dp：
 *
 */
public class LeetCode_115 {

    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] e : dp) Arrays.fill(e, -1);
        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if(s.charAt(i) == t.charAt(j)) res += dfs(i+1, j+1, s, t);
        res += dfs(i+1, j, s, t);
        return dp[i][j] = res;
    }
}
