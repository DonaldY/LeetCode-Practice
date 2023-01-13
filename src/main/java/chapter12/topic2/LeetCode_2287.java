package chapter12.topic2;

import java.util.*;

/**
 * @author donald
 * @date 2023/1/13
 */
public class LeetCode_2287 {

    // 暴力法：哈希表 + 遍历
    // Time: O(n), Space: O(n), Faster: 22.75%
    public int rearrangeCharacters(String s, String target) {
        if (null == s || s.length() == 0) return 0;
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            LinkedList<Integer> list = map.getOrDefault(c, new LinkedList<>());
            list.add(i);
            map.put(c, list);
        }
        int ans = 0;
        while (true) {
            boolean flag = false;
            for (char c : target.toCharArray()) {
                LinkedList<Integer> list = map.get(c);
                if (null == list || list.size() == 0) {
                    flag = true;
                    break;
                }
                list.removeFirst();
            }
            if (flag) break;
            ++ans;
        }
        return ans;
    }
}
