package chapter12.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/02/01
 */
public class LeetCode_2325 {

    // Time: O(m + n), Space: O(n), Faster: 40.51%
    public String decodeMessage(String key, String message) {
        char cur = 'a';
        Map<Character, Character> rules = new HashMap<>();

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (c != ' ' && !rules.containsKey(c)) {
                rules.put(c, cur);
                ++cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); ++i) {
            char c = message.charAt(i);
            if (c != ' ') {
                c = rules.get(c);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
