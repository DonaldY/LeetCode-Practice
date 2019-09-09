package bytedance.string;

import java.util.Arrays;

/**
 * 挑战字符串 - 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 题意: 排列第一个字符串, 看是否为第二个字符串的子串
 *
 * 思路:
 * 1. 枚举所有 s1 子串, 然后再到 s2 中去查找
 * 2. 关注 s2, 在 s2 中查找, 滑动窗口般
 *    只需判断 s1 和 s2 中数组字母数量是否一致
 */
public class CheckInclusion {

    public static void main(String[] args) {

        CheckInclusion checkInclusion = new CheckInclusion();

        System.out.println(checkInclusion.checkInclusionWithSlidingWindow("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {

        return false;
    }

    // Time : o(n), Space: o(1)
    public boolean checkInclusionWithSlidingWindow(String s1, String s2) {

        if (s2 == null || s1 == null) return false;

        if (s1.length() == 0) return true;

        if (s1.length() > s2.length()) return false;

        int [] arr1 = new int[26];
        int [] arr2 = new int[26];

        for (int i = 0; i < s1.length(); ++i) {

            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }

        int window = s1.length();

        for (int i = 0; i < s2.length() - window; ++i) {

            if (Arrays.equals(arr1, arr2)) return true;

            --arr2[s2.charAt(i) - 'a'];
            ++arr2[s2.charAt(i + window) - 'a'];
        }

        return Arrays.equals(arr1, arr2);

    }
}
