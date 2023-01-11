package chapter12.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/01/11
 */
public class LeetCode_2283 {

    // 暴力法： HashMap
    public boolean digitCount(String num) {
        if (null == num || num.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>(num.length());
        for (char c : num.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

    }
}
