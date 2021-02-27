package chapter1.topic1;

/**
 * @author donald
 * @date 2021/02/26
 *
 * LeetCode 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 * ```
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 *
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 *
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 *
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 * ```
 *
 * 题意： 字符串匹配
 * 给你一个字符串 s，和一个模式串 p。你要实现一个能支持 ? 和 * 的通配符匹配。其中，? 可以匹配任意单个非空字符，* 可以匹配 0 个字符或任意多个字符。
 * s 可以是空字符串，也可以是只包含小写字母的非空字符串；p 可以是空字符串，也可以是只包含小写字母、? 或 * 的非空字符串。
 * 注意，p 一定是合法的模式串，并且只有 p 匹配 s 的整个字符串时，才返回 true。
 *
 * 思路：
 * 1. d(i, j) 表示 s(0..i-1) 和 p(0..j-1) 这两个前缀子串是否匹配
 * d(0, 0) = true
 * d(i, 0) = false, i >= 1
 * d(0, j) = d(0, j - 1) (若 p(j-1) == '*')
 *           否则为 false
 */
public class LeetCode_44 {

    private boolean isEqual(char sc, char pc) {
        return sc == pc || pc == '?';
    }

    // Time: O(m*n), Space: O(m*n)
    public boolean isMatchDP(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int i = 1; i <= m; ++i)
            d[i][0] = false;
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j-1) == '*') d[0][j] = d[0][j-1];
            else d[0][j] = false;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (isEqual(sc, pc)) d[i][j] = d[i-1][j-1];
                else if (pc == '*') d[i][j] = d[i][j-1] || d[i-1][j];
                else d[i][j] = false;
            }
        }
        return d[m][n];
    }

    // Time: O(m*n), Space: O(1), Faster: 100.00%
    public boolean isMatchGreedy(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        int i = 0, j = 0, sBegin = -1, pBegin = -1;
        while (i < m) {
            if (j < n && isEqual(s.charAt(i), p.charAt(j))) {
                ++i; ++j;
            } else if (j < n && p.charAt(j) == '*') {
                ++j;
                sBegin = i;
                pBegin = j;
            } else if (pBegin != -1) {
                ++sBegin;
                i = sBegin;
                j = pBegin;
            } else return false;
        }
        while (j < n && p.charAt(j) == '*') ++j;
        return j == n;
    }
}
