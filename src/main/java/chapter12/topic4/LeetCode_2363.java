package chapter12.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2023/02/28
 */
public class LeetCode_2363 {

    // Time: O((n + m)log(n+m)), Space: O(n + m), Faster:
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<>();
            pair.add(k);
            pair.add(v);
            res.add(pair);
        }
        Collections.sort(res, Comparator.comparingInt(a -> a.get(0)));
        return res;
    }
}
