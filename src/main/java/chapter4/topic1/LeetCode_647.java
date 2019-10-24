package chapter4.topic1;

/**
 * 647. Palindromic Substrings
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 题意：回文子串
 *
 * 思路：
 * 1. 暴力求解 o(n^3)
 * 2. 动态规划
 *    i : n - 1 -> 0
 *    j: i -> n - 1
 *    s(i, j)
 *    i == j  ++i
 *    i + 1 == j, s(i) == s(j)
 *    else s(i) == s(j) && s(i + 1, j - 1)?
 *
 * 3. 以字母为中心向外扩展
 */
public class LeetCode_647 {

    public int countSubstrings(String s) {

        return 0;
    }

    // Time: o(n^2), Space: o(n^2), Faster: 24.15%
    public int countPalindromicSubstringDP(String s) {

        if (s == null || s.length() == 0) return 0;

        int n = s.length(), count = 0;
        boolean[][] d = new boolean[n][n]; // 是否为回文子串

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];

                if (d[i][j]) ++count;
            }
        }

        return count;
    }

    // Time: o(n^2), Space: o(1), Faster: 100.00%
    public int countPalindromicSubstringExpand(String s) {

        if (s == null || s.length() == 0) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            ++count;
            --left; ++right;
        }

        return count;
    }
}
