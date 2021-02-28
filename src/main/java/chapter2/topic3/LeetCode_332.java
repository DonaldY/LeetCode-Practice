package chapter2.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2021/02/28
 *
 * LeetCode 332. Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries,
 * you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 *
 * ```
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 *
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 * ```
 *
 * 题意：
 * 这个题目说的是，给你一组由出发机场与到达机场 [from, to] 表示的机票，你要按顺序把途经的机场排列出来。
 * 每个机场都由 3 个大写字母表示，并且一开始从 JFK 机场出发。
 *
 * 注意，所有的机票都要用上，并且它们至少可以组成一个有效的行程。如果存在多个有效行程，则返回字典序最小的那个行程。
 *
 * 为了方便演示，我们假设用单个大写字母来表示机场，并且一开始由 A 机场出发。
 * 比如说，给你的机票是：
 *
 * [B, D]
 * [A, B]
 * [C, E]
 * [D, C]
 *
 * 这 4 张机票只能构成一个有效行程：
 *
 * [A, B, D, C, E]
 *
 * 再比如说，给你的机票是：
 *
 * [A, C]
 * [A, B]
 * [C, B]
 * [B, A]
 *
 * 这 4 张机票可以组成两个有效的行程：
 *
 * [A, B, A, C, B]
 * [A, C, B, A, B]
 *
 * 在这两个有效行程中，出发机场都是 A，然后第一个行程来到机场 B，而第二个行程来到机场 C。B 在字典序上是小于 C 的，因此我们要返回第一个有效行程：
 *
 * [A, B, A, C, B]
 *
 *
 * 思路：
 * 1. 暴力解法
 * 2. 连通图：在一个连通的有向图中，寻找一条固定起点的欧拉路径
 *           欧拉路径是将图中每一条边都正好访问一遍的路径
 *    一个连通的有向图中存在欧拉路径的充要条件是： 存在一个节点，它的出度比入度大1, 同时存在另一个节点，它的入度比出度大1,
 *    其他所有节点的入读都等于出度。或者图上所有节点的入度都等于出度，这时的欧拉路径又叫做欧拉环或欧拉回路。
 *
 *    Hierholzer 算法可以描述如下：
 *    从节点 A 出发，对有向图进行深度优先遍历，并且把访问过的边删除。如果当前节点没有可移动的路径，则把当前节点倒着插入节点访问序列。
 */
public class LeetCode_332 {

    class Pair<F, S> {
        public F first;
        public S second;
        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private boolean dfs(String from, int total, List<String> result,
                        Map<String, List<Pair<String, Boolean>>> map) {
        if (result.size() == total) return true;
        List<Pair<String, Boolean>> tos = map.get(from);
        if (tos == null) return false;

        for (Pair<String, Boolean> e: tos) {
            if (e.second) continue;
            e.second = true;
            result.add(e.first);
            if (dfs(e.first, total, result, map)) return true;
            result.remove(result.size()-1);
            e.second = false;
        }
        return false;
    }

    // Time: O(n!), Space: O(n)
    public List<String> findItineraryBruteForce(List<List<String>> tickets) {
        Map<String, List<Pair<String, Boolean>>> map = new HashMap<>();
        for (List<String> e: tickets) {
            if (!map.containsKey(e.get(0))) map.put(e.get(0), new ArrayList<>());
            map.get(e.get(0)).add(new Pair<>(e.get(1), false));
        }
        for (List<Pair<String, Boolean>> list: map.values())
            list.sort(Comparator.comparing(pair -> pair.first));
        int total = tickets.size() + 1;
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", total, result, map);
        return result;
    }

    private void hierholzer(String from, List<String> result,
                            Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty())
            hierholzer(tos.poll(), result, map);
        result.add(0, from);
    }

    // Time: O(n*log(n)), Space: O(n), Faster: 99.64%
    public List<String> findItineraryHierholzer(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> e: tickets) {
            if (!map.containsKey(e.get(0))) map.put(e.get(0), new PriorityQueue<>());
            map.get(e.get(0)).add(e.get(1));
        }
        List<String> result = new LinkedList<>();
        hierholzer("JFK", result, map);
        return result;
    }
}
