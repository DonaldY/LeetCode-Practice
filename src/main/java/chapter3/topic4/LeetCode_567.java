package chapter3.topic4;


import java.util.Arrays;

/**
 * @author donald
 * @date 2022/08/08
 *
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 思路： 固定大小滑动窗口
 */
public class LeetCode_567 {

    // Time: O(n * n), Space: O(n), Faster: 55.84%
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;
        char[] s1c = new char[26];
        char[] s2c = new char[26];

        // 1. 初始化滑动窗口
        for (int i = 0; i < s1.length(); ++i) {
            s1c[s1.charAt(i) - 'a']++;
            s2c[s2.charAt(i) - 'a']++;
        }
        // 1.2. 判断初始化滑动窗口 是否 满足题意
        if (Arrays.equals(s1c, s2c)) return true;
        // 2. 滑动窗口不断移动
        for (int i = s1.length(); i < s2.length(); ++i) {
            s2c[s2.charAt(i) - 'a']++;        // 右侧边扩
            s2c[s2.charAt(i - s1.length()) - 'a']--; // 左侧边进
            if (Arrays.equals(s1c, s2c)) return true; // 判断是否满足题意
        }
        return false;
    }

    // 方法：滑动窗口 + 哈希表
    // Time: O(n), Space: O(1), Faster: 85.58%
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int [] map = new int[26];
        for (char c : s1.toCharArray()) ++map[c - 'a'];  // 1. 哈希表记录需要的字符个数
        // 2. 滑动窗口移动
        for (int left = 0, right = 0; right < s2.length(); ++right) {
            --map[s2.charAt(right) - 'a'];           // 进滑动窗口
            while (right - left + 1 > s1.length()) { // 出滑动窗口
                ++map[s2.charAt(left) - 'a'];
                ++left;
            }
            if (isValid(map)) return true;
        }
        return false;
    }

    private boolean isValid(int[] map) {
        for (int num : map) {
            if (num != 0) return false;
        }
        return true;
    }




















}
