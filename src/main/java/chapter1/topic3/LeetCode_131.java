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

    private void partition(String s, int start, boolean[][] d,
                           List<List<String>> result, List<String> elem) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(elem));
        } else {
            for (int end = start; end < s.length(); ++end) {
                if (d[start][end]) {
                    elem.add(s.substring(start, end + 1));
                    partition(s, end + 1, d, result, elem);
                    elem.remove(elem.size() - 1);
                }
            }
        }
    }

    // Time: o(2 ^ n), Space: o(n ^ 2), Faster: 97.45%
    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) return Collections.emptyList();

        List<List<String>> result = new ArrayList<>();

        int n = s.length();
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i + 1][j - 1];
            }
        }

        partition(s, 0, d, result, new ArrayList<>());

        return result;
    }
}
