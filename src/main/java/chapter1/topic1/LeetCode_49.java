package chapter1.topic1;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * 题意： 给你一个字符串数组，你要把变位词划分到一组。其中，字符串只由小写字母组成。
 * 变位词指的是使用相同字母以不同顺序构成的单词。
 *
 * 思路：
 * 1. 先排序，存到对应的 hashmap
 * 2.
 */
public class LeetCode_49 {

    // Time: O(n * k), Space: O(n), Faster: 99.46%
    // Time: O(n * k * log(k)), Space: O(n), Faster: 96.95%
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKeyByCount(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getKeyBySort(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // Time: O(k), Faster: 99.46%
    private String getKeyByCount(String s) {
        char[] c = new char[26];
        for (int i = 0; i < s.length(); ++i)
            c[s.charAt(i) - 'a']++;
        return new String(c);
    }

    // Time: O(k), 只保存有意义的数
    private String getKeyByCount2(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i)
            c[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i)
            if (c[i] != 0)
                sb.append((char)(i + 'a')).append(c[i]);
        return sb.toString();
    }
}
