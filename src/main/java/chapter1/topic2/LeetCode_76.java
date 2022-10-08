package chapter1.topic2;

/**
 * LeetCode 76 - Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * 题意：找到最小窗口，包含子串所有字符，如果没有返回 空
 *
 * 思路： 滑动窗口
 * 1. 记录子串位置，逐个比较
 * 2. 哈希表 + 双指针，逐个比较
 */
public class LeetCode_76 {

    // Time: o(n), Space: o(n), Faster: 96.14%
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        // 1. 哈希表：用于记录需要的字符
        int [] required = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            ++required[t.charAt(i)];
        }
        // 2. 记录结果。 count： 记录需要的总字符数
        int start = 0, len = Integer.MAX_VALUE, count = t.length();

        // 3. 滑动窗口移动
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (required[r] > 0) --count; // 命中需要的字符，总字符数 -1
            --required[r];

            // 判断左侧窗口是否要收缩：已经获得所有字符
            while (count == 0) {
                // 更新答案
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char l = s.charAt(left);
                ++required[l];
                if (required[l] > 0) ++count;
                ++left;
            }
            ++right;
        }
        return len == Integer.MAX_VALUE ? "": s.substring(start, start + len);
    }

    // 方法： 滑动窗口
    // Time: O(n), Space: O(1), Faster: 30.48%
    public String minWindow2(String s, String t) {
        if (t.length() > s.length()) return "";
        int n = t.length();
        int[] map = new int[256];
        for (char c : t.toCharArray()) ++map[c];
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); ++r) {
            --map[s.charAt(r)];
            if (r - l + 1 < n) continue;
            while (isValid(map)) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    left = l; right = r;
                }
                ++map[s.charAt(l)];
                ++l;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(left, right + 1);
    }

    private boolean isValid(int[] map) {
        for (int num : map) {
            if (num > 0) return false;
        }
        return true;
    }


}
