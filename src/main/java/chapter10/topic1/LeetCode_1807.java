package chapter10.topic1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author donald
 * @date 2023/01/12
 */
public class LeetCode_1807 {

    // Time: O(n + k), Space: O(n + k), Faster: 29.44%
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();

    }
}
