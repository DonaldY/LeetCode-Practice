package chapter4.topic2;

/**
 * @author donald
 * @date 2022/09/25
 *
 * 验证回文串 II
 *
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 *
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：false
 *
 *
 * 思路：
 * 1. 暴力法： 双指针， 两边判断只有 1次是错机会。
 */
public class LeetCode_680 {

    // Time: O(n), Space: O(1), Faster: 56.02%
    public boolean validPalindrome(String s) {
        if (null == s || s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left + 1, right)
                        || isValid(s, left, right - 1);
            }
            ++left;
            --right;
        }
        return true;
    }

    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            ++left;
            --right;
        }
        return true;
    }
}
