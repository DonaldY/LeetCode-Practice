package chapter1.topic2;

/**
 * 91. Decode Ways
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * 题意：
 * 给出一串数组，用`A-Z`来表示，有多少种可能
 *
 * 有效解码只可能是一个字符或者两个字符
 *
 * 思路：
 * 1. 先拆分数组，然后再每个进行求解，递归求解
 * 2. DP（记忆化子问题的解，来求解原问题的解）
 *
 * d(i) 表示字符串s中前i个字符（即下标为0～i-1的字符）的解码方式数量
 *
 */
public class LeetCode_91 {

    public int numDecodings(String s) {

        return 0;
    }

    private boolean isValidTwoDigit(char a, char b) {
        return (a == '1' && b <= '9') || (a == '2' && b <= '6');
    }

    private int decode(char[] c, int i) {
        if (i == c.length) return 1;
        if (i == c.length - 1 && c[i] != '0') return 1;
        if (i > c.length) return 0;
        if (i == c.length - 1 && c[i] == '0') return 0;
        int num = 0;
        if (c[i] != '0') num += decode(c, i + 1);
        if (isValidTwoDigit(c[i], c[i + 1])) num += decode(c, i + 2);
        return num;
    }

    // Time: o(n), Space: o(n), Faster: 5.03%
    public int numberOfDecodingRecursive(String s) {
        return decode(s.toCharArray(), 0);
    }

    // Time: o(n), Space: o(n), Faster: 98.68%
    public int numberOfDecodingDP(String s) {
        int [] d = new int[s.length() + 1];
        d[0] = 1;
        d[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
            if (isValidTwoDigit(s.charAt(i  - 2), s.charAt(i - 1))) d[i] += d[i - 2];
        }
        return d[s.length()];
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int numberOfDecodingsDPO1(String s) {
        int first = 1;
        int second = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); ++i) {
            int third = 0;
            if (s.charAt(i-1) != '0') third += second;
            if (isValidTwoDigit(s.charAt(i-2), s.charAt(i-1))) third += first;
            first = second;
            second = third;
        }
        return second;
    }
}
