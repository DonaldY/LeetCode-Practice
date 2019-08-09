package chapter1.topic1;

/**
 * 14. Longest Common Prefix
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * 题意：
 * 找到最长匹配的前缀
 *
 * 思路：
 * 同时比对
 */
public class LeetCode_14 {

    // Time: o(n ^ 2), Space: o(1), Faster: 74.21%
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        int i = 0;

        for (; i < strs[0].length(); ++i) {

            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; ++j) {

                    if (strs[j].length() <= i || c != strs[j].charAt(i)) {

                        return strs[0].substring(0, i);
                    }
            }
        }

        return strs[0];
    }
}
