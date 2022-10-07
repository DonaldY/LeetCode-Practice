package chapter1.topic1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3 LongestSubstringWithoutRepeatingCharacters
 *
 * Given a string, find the length of the longest substring without repeating characters
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * 题意：最长子串
 *
 * 思路：
 * 1. 暴力解决
 * 2. 滑动窗口
 *    即双指针： i, j（i 表示起始，j 表示移动）
 *
 *    当j 遇到 重复数字时候， i ++， j + 1
 *
 *    优化：
 *    i = index[首个重复数字下标] 开始， j = j + 1
 */

public class LeetCode_3 {

    public static void main(String[] args) {
        String str = "abcade";

        LeetCode_3 longest = new LeetCode_3();

        System.out.println(longest.lengthOfLongestSubstring2N(str));
    }

    // 方法一： 滑动窗口
    // Time: O(n), Space: O(m), m 是字符集大小, Faster: 92.19%
    public int lengthOfLongestSubstring(String s) {

        int [] counts = new int[256]; // 记录字符出现的次数
        int left = 0, right = 0;      // 定义滑动窗口左右指针
        int ans = 0;                  // 记录结果

        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;     // 右指针右移动 +1
            ++counts[c]; // 更新窗口内数据
            // 判断左侧窗口是否要收缩
            while (counts[c] > 1) {
                char d = s.charAt(left);
                ++left;
                // 更新窗口内数据
                --counts[d];
            }
            // 更新最大值
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    // 方法二： 滑动窗口优化
    // Time: O(n), Space: O(m), m 是字符集大小, Faster: 92.19%
    public int lengthOfLongestSubstring1(String s) {

        int [] counts = new int[256]; // 记录字符出现的次数
        int left = 0, right = 0;      // 定义滑动窗口左右指针
        int ans = 0;                  // 记录结果

        while (right < s.length()) {
            char c = s.charAt(right);
            ++right;     // 右指针右移动 +1
            ++counts[c]; // 更新窗口内数据
            // 判断左侧窗口是否要收缩
            while (counts[c] > 1) {
                char d = s.charAt(left);
                ++left;
                // 更新窗口内数据
                --counts[d];
            }
            // 更新最大值
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    // Time: O(n), Space: O(m), m 是字符集大小, Faster: 92.19%
    public int lengthOfLongestSubstring2N(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i < s.length(); ++i) {
            for (; j < s.length(); ++j) {
                if (counts[s.charAt(j)] != 0) break;
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i); // j - i is current length
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }

    // Time: O(n), Space: O(m)，m 是字符集大小, Faster: 92.19%
    public int lengthOfLongestSubstring1N(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); ++right) {
            left = Math.max(index[s.charAt(right)] + 1, left);
            maxLen = Math.max(maxLen, right - left + 1);
            index[s.charAt(right)] = right;
        }
        return maxLen;
    }

    // 方法： 滑动窗口 + 哈希表
    // Time: O(n), Space: O(n), Faster: 67.89%
    public int lengthOfLongestSubstringMine(String s) {
        if (null == s || s.length() == 0) return 0;
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>(); // 记录字符出现的下标
        for (int left = 0, right = 0; right < s.length(); ++right) {
            int c = s.charAt(right) - 'a';
            if (map.containsKey(c)) {
                int idx = map.get(c);
                while (left <= idx) {
                    map.remove(s.charAt(left) - 'a');
                    ++left;
                }
            }
            map.put(c, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }






















}
