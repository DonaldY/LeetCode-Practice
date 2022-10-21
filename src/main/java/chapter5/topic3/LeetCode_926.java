package chapter5.topic3;

/**
 * @author donald
 * @date 2022/10/21
 *
 * 思路：
 * 1. 动态规划：
 */
public class LeetCode_926 {

    // Time: O(n), Space: O(n), Faster:
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];

        // 1. 初始化值
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;  // 以 0 结尾的反转次数
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;  // 以 1 结尾的反转次数

        // 2. 状态转移
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }

        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
