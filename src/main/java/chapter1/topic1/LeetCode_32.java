package chapter1.topic1;

/**
 * 32. Longest Valid Parentheses
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * 题意： 找到最长合法匹配子串
 *
 *
 * 思路：
 * 1. 额外栈，遇到`(`进栈，遇到`)`出栈，若不匹配直接抛弃
 * 2. DP，
 *    d(i) 表示以第 i 个字符结尾的有效括号子串的最大长度
 *    d(i) = 2 + d(i - 1)
 *
 */
public class LeetCode_32 {

    public int longestValidParentheses(String s) {

        return 0;
    }

    // Time: o(n), Space: o(n), Faster: 100.00%
    public int maxLengthOfValidParenthesesStack(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), p = -1, max = 0;
        int [] st = new int[n + 1];
        st[++p] = -1;

        for (int i = 0; i < n; ++i) {
            if (st[p] != -1 && s.charAt(st[p]) == '(' && s.charAt(i) == ')') {
                --p;
                max = Math.max(max, i - st[p]);
            } else st[++p] = i;
        }
        return max;
    }

    // Time: o(n), Space: o(n), Faster: 100.00%
    public int maxLengthOfValidParenthesesDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), left = 0, max = 0;
        int [] d = new int[n];

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else if (left > 0) {
                d[i] = d[i - 1] + 2;
                d[i] += (i - d[i]) >= 0 ? d[i - d[i]] : 0;
                max = Math.max(max, d[i]);
                --left;
            }
        }
        return max;
    }
}
