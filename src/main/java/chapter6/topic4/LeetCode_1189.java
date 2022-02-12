package chapter6.topic4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/02/13
 *
 * 1189. “气球” 的最大数量
 *
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 * 题意： 可以拼的字母数
 *
 * 思路：
 * 1. 暴力法： map 存储，比较对小值
 */
public class LeetCode_1189 {

    // Time: O(n), Space: O(n), Faster: 39.68%
    public int maxNumberOfBalloons(String text) {

        if (null == text || text.length() == 0) return 0;

        Map<Character, Integer> charMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (char c : text.toCharArray()) {

            switch (c) {
                case 'b': charMap.put('b', charMap.getOrDefault('b', 0) + 1);break;
                case 'a': charMap.put('a', charMap.getOrDefault('a', 0) + 1);break;
                case 'l': charMap.put('l', charMap.getOrDefault('l', 0) + 1);break;
                case 'o': charMap.put('o', charMap.getOrDefault('o', 0) + 1);break;
                case 'n': charMap.put('n', charMap.getOrDefault('n', 0) + 1);break;
            }
        }

        ans = Math.min(ans, charMap.getOrDefault('b', 0));
        ans = Math.min(ans, charMap.getOrDefault('a', 0));
        ans = Math.min(ans, charMap.getOrDefault('n', 0));
        ans = Math.min(ans, charMap.getOrDefault('l', 0) / 2);
        ans = Math.min(ans, charMap.getOrDefault('o', 0) / 2);

        return ans;
    }
}
