package chapter12.topic3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2023/01/27
 */
public class LeetCode_2309 {

    // 暴力法： 哈希表
    // Time: O(n), Space: O(1), Faster: 100.00%
    public String greatestLetter(String s) {
        Set<Character> ht = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ht.add(c);
        }
        for (int i = 25; i >= 0; i--) {
            if (ht.contains((char) ('a' + i)) && ht.contains((char) ('A' + i))) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
