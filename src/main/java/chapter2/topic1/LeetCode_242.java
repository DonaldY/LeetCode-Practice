package chapter2.topic1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/08/20
 *
 * 这个题目说的是，给你两个字符串 s 和 t，你要写函数判断 t 是否为 s 的一个变位词。
 *
 * 其中，字符串只由小写字母组成。变位词指的是使用相同字母以不同顺序构成的单词。
 *
 * 比如说，给你的字符串 s 和 t 是：
 *
 * s = "eat"
 * t = "tea"
 *
 * 这两个字符串都是由 a/e/t 这三个字母构成，因此 t 是 s 的一个变位词。
 *
 * 如果 s 和 t 改成：
 *
 * s = "eat"
 * t = "ten"
 *
 * "ten" 中的字符 n 不存在于字符串 s 中。因此，它不是 s 的一个变位词。
 *
 * 1. 哈希表 : hashmap 两两比对
 * 2. 排个序，逐一比对
 */
public class LeetCode_242 {
    // Time: O(n), Space: O(n), Faster: 5.40%
    public boolean isAnagram(String s, String t) {
        if (null == s && null == t) return true;
        if (null != s && s.length() == 0 && null != t && t.length() == 0) return true;
        if (null == s || null == t) return false;
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int num = sMap.getOrDefault(c, 0);
            sMap.put(c, num + 1);
            c = t.charAt(i);
            num = tMap.getOrDefault(c, 0);
            tMap.put(c, num + 1);
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(tMap.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }

    // 方法二： 排序
    // Time: O(n*log(n)), Space: O(n), Faster: 79.37%
    public boolean isAnagramSort(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; ++i)
            if (sc[i] != tc[i])
                return false;
        return true;
    }
}
