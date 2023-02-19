package chapter12.topic3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author donald
 * @date 2023/02/20
 */
public class LeetCode_2347 {

    // 哈希表 + 计数
    // Time: O(n), Space: O(n), Faster: 31.32%
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<>();
        for (char suit : suits) {
            suitsSet.add(suit);
        }
        if (suitsSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> h = new HashMap<>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
