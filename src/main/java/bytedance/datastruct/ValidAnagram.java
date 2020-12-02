package bytedance.datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2020/12/02
 *
 * Leetcode 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 思路：
 * 1. 用两个 hashMap 存储，然后两个 map 对比
 * 2. 排序， 之后一一对比
 * 3. 用一个 26 字母表，遍历 s 增，遍历 t 减，看最后字母表是否为0
 */
public class ValidAnagram {

    // Time: O(n), Space: O(n), Faster: 22.11%
    public boolean isAnagram(String s, String t) {

        if (null == s || null == t) return false;

        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>(s.length());
        Map<Character, Integer> tMap = new HashMap<>(t.length());

        for (int i = 0; i < s.length(); ++i) {

            executeMap(i, sMap, s);
            executeMap(i, tMap, t);
        }

        if (sMap.size() != tMap.size()) return false;

        for (char ss : sMap.keySet()) {

            if (!tMap.containsKey(ss)) return false;

            int cnt = tMap.get(ss);
            if (cnt != sMap.get(ss)) return false;
        }

        return true;
    }

    private void executeMap(int index, Map<Character, Integer> map, String s) {

        char ss = s.charAt(index);

        if (!map.containsKey(ss)) {

            map.put(ss, 1);
        }

        Integer cnt = map.get(ss);
        map.put(ss, cnt + 1);
    }
}
