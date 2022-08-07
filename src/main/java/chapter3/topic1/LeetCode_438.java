package chapter3.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2020/5/6
 *
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * 题意：
 * 从s中找到p的所有连续组合，并返回每一组的第一个下标
 *
 * 思路：
 * 1. 滑动窗口(hash表), 暴力法
 *    1. hash表， s、p映射
 *    2. 遍历s，每次对比
 *
 * 2. 滑动窗口(hash表), 两个指针
 *    1. 用left、right指针表示， len(right - left) == p.length()， 则表示相等了。
 */
public class LeetCode_438 {

    public static void main(String[] args) {

        LeetCode_438 leetCode_438 = new LeetCode_438();

        System.out.println(leetCode_438.findAnagrams("cbaebabacd", "abc"));
        System.out.println(leetCode_438.findAnagrams("abab", "ab"));
    }

    // Time: O(n * n), Space: O(n), Faster: 86.62%
    public List<Integer> findAnagrams(String s, String p) {

        if (s == null || p == null
                || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {

            return Collections.emptyList();
        }

        int [] sAtr = new int[256];
        int [] pAtr = new int[256];

        for (int i = 0; i < p.length(); ++i) {

            pAtr[p.charAt(i)] ++;
        }

        for (int i = 0; i < p.length() - 1; ++i) {

            sAtr[s.charAt(i)] ++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - p.length(); ++i) {

            sAtr[s.charAt(i + p.length() - 1)] ++;

            if (Arrays.equals(sAtr, pAtr)) {

                result.add(i);
            }

            sAtr[s.charAt(i)] --;
        }

        return result;
    }

    // Time: O(n), Space: O(k), Faster: 94.93%
    public List<Integer> findAnagramsOn(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return result;
        int sLen = s.length(), pLen = p.length();
        char[] pc = new char[26];
        for (int i = 0; i < pLen; ++i) {
            pc[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        while (right < sLen) {
            if (pc[s.charAt(right) - 'a'] > 0) {
                pc[s.charAt(right) - 'a']--;
                ++right;
            } else {
                pc[s.charAt(left) - 'a']++;
                ++left;
            }
            if (right - left == pLen) result.add(left);
        }
        return result;
    }
}
