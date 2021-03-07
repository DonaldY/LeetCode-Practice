package chapter1.topic3;

/**
 * @author donald
 * @date 2021/03/08
 *
 * LeetCode 132. 分割回文串 II
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 * ```
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 *
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 *
 *
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 * ```
 *
 * 题意： 分割多少次，使其子串均为回文串
 *
 *
 * 思路：
 * 1. 动态规划
 * 2. 从中间展开
 *
 */
public class LeetCode_132 {

    // Time: O(n^2), Space: O(n^2), Faster: 52.68%
    public int minCutDP(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        boolean[][] d = new boolean[n][n];
        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i+1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];
            }
        }

        int[] cut = new int[n+1];
        cut[0] = -1;
        for (int j = 0; j < n; ++j) {
            cut[j+1] = cut[j] + 1;
            for (int i = j-1; i >= 0; --i) {
                if (d[i][j]) {
                    cut[j+1] = Math.min(cut[j+1], cut[i]+1);
                }
            }
        }
        return cut[n];
    }

    // Time: O(n^2), Space: O(n^2), Faster: 67.90%
    public int minCutDPOpt(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        boolean[][] d = new boolean[n][n];
        int[] cut = new int[n+1];
        cut[0] = -1;
        for (int j = 0; j < n; ++j) {
            d[j][j] = true;
            cut[j+1] = cut[j] + 1;
            for (int i = j-1; i >= 0; --i) {
                if (s.charAt(i) == s.charAt(j) && (i+1 == j || d[i+1][j-1])) {
                    d[i][j] = true;
                    cut[j+1] = Math.min(cut[j+1], cut[i]+1);
                }
            }
        }
        return cut[n];
    }

    // Time: O(n^2), Space: O(n), Faster: 91.51%
    public int minCutExpand(String s) {
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        int[] cut = new int[n+1];
        for (int i = 0; i <= n; ++i) cut[i] = i - 1;

        for (int p = 0; p < n; ++p) {
            expand(s, p, p, cut);
            expand(s, p, p+1, cut);
        }
        return cut[n];
    }

    private void expand(String s, int i, int j, int[] cut) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            cut[j+1] = Math.min(cut[j+1], cut[i]+1);
            --i; ++j;
        }
    }
}
