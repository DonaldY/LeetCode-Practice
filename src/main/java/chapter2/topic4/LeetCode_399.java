package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2021/03/16
 *
 * LeetCode 399. Evaluate Division
 *
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 * ```
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 *
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 *
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * ```
 *
 * 题意：这个题目说的是，给你一系列形如 A / B = K 的等式，其中 A 和 B 是字符串，K 是浮点数。
 *      你要根据这些等式，为一系列的除法表达式求值。
 *      如果求值结果不存在，就返回 -1.0。
 *
 *      注意，假设给你的输入总是有效的。也就是说你不需要考虑除 0 或者输入中存在其他问题的情况。
 *
 * 思路：
 *
 */
public class LeetCode_399 {

    private Double dfs(String cur, String end, double result,
                       Set<String> visited,
                       Map<String, Map<String, Double>> graph) {
        Map<String, Double> nexts = graph.get(cur);
        if (nexts.containsKey(end)) return result * nexts.get(end);
        for (Map.Entry<String, Double> next: nexts.entrySet()) {
            if (visited.contains(next.getKey())) continue;
            visited.add(next.getKey());
            Double ret = dfs(next.getKey(), end, result * next.getValue(), visited, graph);
            if (ret != null) return ret;
        }
        return null;
    }

    // Time: O(m*V), Space: O(V+E), Faster: 100.00%
    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!graph.containsKey(a)) graph.put(a, new HashMap<>());
            graph.get(a).put(b, values[i]);
            if (!graph.containsKey(b)) graph.put(b, new HashMap<>());
            graph.get(b).put(a, 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1.0;
            } else if (a.equals(b)) {
                result[i] = 1.0;
            } else {
                Double ret = dfs(a, b, 1.0, new HashSet<>(), graph);
                result[i] = ret != null ? ret : -1.0;
            }
        }
        return result;
    }
}
