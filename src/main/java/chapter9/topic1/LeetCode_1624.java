package chapter9.topic1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author donald
 * @date 2022/09/17
 *
 * 1624. 两个相同字符之间的最长子字符串
 *
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * 示例 1：
 *
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 *
 * 思路： hash表
 */
public class LeetCode_1624 {

    // Time: O(n), Space: O(n), Faster: 18.31%
    public int maxLengthBetweenEqualCharacters(String s) {
        if (null == s || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < s.toCharArray().length; ++i) {
            char c = s.charAt(i);
            Integer d = map.get(c);
            if (Objects.isNull(d)) {
                map.put(c, i);
            } else {
                ans = Math.max(ans, i - d - 1);
            }
        }
        return ans;
    }
}
