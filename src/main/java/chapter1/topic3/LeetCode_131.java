package chapter1.topic3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 题意： 回文分割，找到字符串中所有回文，分割后还是回文
 *
 * 思路：
 * 1. 两层for循环
 * 2. 中间开花，从中间向两边扩展
 * 3. 高中知识：插孔法
 *
 *    start    end
 *     0        start -> n - 1
 *     end + 1  start - > n - 1
 *
 *     start >= n + 1
 */
public class LeetCode_131 {

    // Time: O(n^2), Space: O(n^2)
    public int countPalindromicSubstringsDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), count = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i+1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];

                if (d[i][j]) ++count;
            }
        }

        return count;
    }

    // Time: O(n^2), Space: O(1)
    public int countPalindromicSubstringsExpand(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            // 奇数
            count += expand(s, i, i);
            // 偶数
            count += expand(s, i, i+1);
        }
        return count;
    }

    int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left; ++right;
        }
        return count;
    }
}
