package chapter3.topic1;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * 题意： 根据输入的字符串，组成一个最长回文
 *
 * 思路：
 * 1. 找到成对出现的字母（可直接使用），可再找单个数字
 * 把每个字母，哈希存储起来
 *
 * 2.
 */
public class LeetCode_409 {

    public static void main(String[] args) {

        LeetCode_409 leetCode_409 = new LeetCode_409();

        System.out.println(leetCode_409.longestPalindrome("abccccdd"));
    }

    // Time: o(n), Space: o(n), Faster: 14.47%
    public int longestPalindrome(String s) {

        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); ++i) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {

                int cnt = map.get(c);

                map.put(c, ++cnt);
            } else {

                map.put(c, 1);
            }
        }

        int result = 0;

        boolean isSingle = false;

        for (Integer cnt : map.values()) {

            if (cnt % 2 == 1) isSingle = true;

            result += (cnt / 2) * 2;
        }

        if (isSingle) {
            ++ result;
        }

        return result;
    }


    // Time: o(n), Space: o(m), Faster: 100.00%
    public int lengthOfLongestPalindrome(String s) {
        int[] d = new int[256];
        int oddNum = 0;
        for (char c: s.toCharArray())
            ++d[c];
        for (int count: d)
            if (count % 2 == 1)
                ++oddNum;
        int unUsed = Math.max(0, oddNum-1);
        return s.length() - unUsed;
    }
}
