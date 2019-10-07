package chapter2.topic4;

import java.util.*;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * 题意： 在字符串中找到第一个唯一的字母
 *
 * 思路：
 * 1. hash表， 需要记录字符的下标和出现的次数
 *    hash表存储位置，set表示存在
 *
 * 2. 统计变量出现的次数，然后再遍历一遍查到第一个出现次数等于1的
 * 3. 在2的基础上， 减少遍历的范围
 */
public class LeetCode_387 {

    // Time: O(n), Space: O(n), Faster: 35.55%
    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {

            if (!set.contains(s.charAt(i))) {
                char c = s.charAt(i);
                set.add(c);
                map.put(c, i);
                queue.add(c);
            } else if (set.contains(s.charAt(i))) {

                queue.remove(s.charAt(i));
            }
        }

        if (queue.isEmpty()) return -1;

        return map.get(queue.peek());
    }

    // Time: O(n), Space: O(m), Faster: 80.46%
    public int firstUniqCharTwoPass(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i)
            ++count[s.charAt(i) - 'a'];
        for (int i = 0; i < s.length(); ++i)
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    // Time: O(n), Space: O(m), Faster: 64.13%
    public int firstUniqCharOnePass(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            ++count[idx];
            if (pos[idx] == -1) pos[idx] = i;
        }
        int firstPos = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i)
            if (count[i] == 1)
                firstPos = Math.min(firstPos, pos[i]);
        return firstPos == Integer.MAX_VALUE ? -1 : firstPos;
    }
}
