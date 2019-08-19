package chapter1.topic3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * 题意： wordDict中所有字符串能在 s 中体现
 *
 * 思路：
 * 1. 暴力，直接每个都查找
 * 2. 动态规划： d(i) 表示前 i 个字符（下标 0 ～ i - 1）组成的子串是否能分解成列表中的若干字串
 *
 *
 */
public class LeetCode_139 {

    // Time: o(n ^ 2), Space: o(n + m), Faster: 94.47%
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean [] d = new boolean[n + 1];
        d[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (d[j] && set.contains(s.substring(j, i))) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[n];
    }
}
