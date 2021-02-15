package chapter1.topic1;

import java.util.Arrays;

/**
 *  Regular Expression Matching
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * 当 * 后面没有字符，但 s 还有字母， 则 * 模仿前面一个字母并与对应字母比对
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * . 都跳过，遇到 *
 *
 * means：p=".."
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * Input:
 * s = "sssss"
 * p = "ss*s"
 * Output: false
 *
 * Input:
 * s = "ssssss"
 * p = "ss*s.*"
 * Output: true
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * 思路：
 * 1. 把所有可能都列举出来，然后匹配
 * 2. 逐字匹配，遇到 * 联系上下文
 *
 * 实际解决:
 * 1.
 *
 * https://www.cnblogs.com/grandyang/p/4461713.html
 */
public class LeetCode_10 {

    public static void main(String[] args) {

        LeetCode_10 leetCode = new LeetCode_10();

        System.out.println(leetCode.isMatch("aa", "a")); // false
        System.out.println(leetCode.isMatch("aa", "a*")); // true
        System.out.println(leetCode.isMatch("aa", ".*")); // true
        System.out.println(leetCode.isMatch("mississippi", "mis*is*p*.")); // false
    }

    // Faster: 11.51%
    public boolean isMatch(String s, String p) {

        // 正则串为空
        if (p.isEmpty()) {

            return s.isEmpty();
        }

        // 正则串长度为 1
        if (p.length() == 1) {

            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }

        // 正则串第二个字符不是 *
        if (p.charAt(1) != '*') {

            if (s.isEmpty()) {

                return false;
            }

            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {

            if (isMatch(s, p.substring(2))) {
                return true;
            }

            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }

    // Time: O(m*n), Space: O(m*n), Faster: 99.58%
    public boolean isMatchDP(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int i = 1; i <= m; ++i)
            d[i][0] = false;
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j-1) == '*') d[0][j] = d[0][j-2];
            else d[0][j] = false;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (isEqual(sc, pc)) {
                    d[i][j] = d[i-1][j-1];
                } else if (pc == '*') {
                    char preChar = p.charAt(j-2);
                    if (isEqual(sc, preChar)) d[i][j] = d[i][j-2] || d[i][j-1] || d[i-1][j];
                    else d[i][j] = d[i][j-2];
                } else {
                    d[i][j] = false;
                }
            }
        }
        return d[m][n];
    }

    private boolean isEqual(char sc, char pc) {
        return sc == pc || pc == '.';
    }

    // Time: O(m*n), Space: O(m*n), Faster: 62.74%
    public boolean isMatchShort(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int j = 1; j <= n; ++j)
            if (p.charAt(j-1) == '*')
                d[0][j] = d[0][j-2];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (isEqual(sc, pc)) {
                    d[i][j] = d[i-1][j-1];
                } else if (pc == '*') {
                    char preChar = p.charAt(j-2);
                    if (isEqual(sc, preChar)) d[i][j] = d[i][j-2] || d[i][j-1] || d[i-1][j];
                    else d[i][j] = d[i][j-2];
                } else {
                    d[i][j] = false;
                }
            }
        }
        return d[m][n];
    }

    // Time: O(m*n), Space: O(n), Faster: 62.74%
    public boolean isMatchTwoArray(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[] pre = new boolean[n+1];
        boolean[] cur = new boolean[n+1];
        pre[0] = true;
        for (int j = 1; j <= n; ++j)
            if (p.charAt(j-1) == '*')
                pre[j] = pre[j-2];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (isEqual(sc, pc)) {
                    cur[j] = pre[j-1];
                } else if (pc == '*') {
                    char preChar = p.charAt(j-2);
                    if (isEqual(sc, preChar)) cur[j] = cur[j-2] || cur[j-1] || pre[j];
                    else cur[j] = cur[j-2];
                } else {
                    cur[j] = false;
                }
            }
            boolean[] tmp = cur;
            cur = pre;
            pre = tmp;
            Arrays.fill(cur, false);
        }
        return pre[n];
    }

    // Time: O(m*n), Space: O(n), Faster: 62.74%
    public boolean isMatchOneArray(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[] cur = new boolean[n+1];
        cur[0] = true;
        for (int j = 1; j <= n; ++j)
            if (p.charAt(j-1) == '*')
                cur[j] = cur[j-2];

        for (int i = 1; i <= m; ++i) {
            boolean pre = cur[0];
            cur[0] = false;
            for (int j = 1; j <= n; ++j) {
                boolean tmp = cur[j];
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
                if (isEqual(sc, pc)) {
                    cur[j] = pre;
                } else if (pc == '*') {
                    char preChar = p.charAt(j-2);
                    if (isEqual(sc, preChar)) cur[j] = cur[j-2] || cur[j-1] || cur[j];
                    else cur[j] = cur[j-2];
                } else {
                    cur[j] = false;
                }
                pre = tmp;
            }
        }
        return cur[n];
    }
}
