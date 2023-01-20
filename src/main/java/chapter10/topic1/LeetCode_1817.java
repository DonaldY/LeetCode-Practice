package chapter10.topic1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author donald
 * @date 2023/01/20
 */
public class LeetCode_1817 {

    // 暴力法：哈希表
    // Time: O(n + k), Space: O(n + k), Faster:
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            activeMinutes.putIfAbsent(id, new HashSet<>());
            activeMinutes.get(id).add(time);
        }
        int[] answer = new int[k];
        for (Set<Integer> minutes : activeMinutes.values()) {
            int activeCount = minutes.size();
            answer[activeCount - 1]++;
        }
        return answer;
    }
}
