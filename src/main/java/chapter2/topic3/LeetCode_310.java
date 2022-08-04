package chapter2.topic3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author donald
 * @date 2020/5/11
 *
 * 310. Minimum Height Trees
 *
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 * Example 2 :
 *
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 * Note:
 *
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 * 题意：
 * 给你一个没有环的无向图，把图上任意一个节点当作根节点，就可以把它看作一棵树。
 * 这样一来，对于一个包含 n 个节点的无环无向图，可以产生 n 棵不同的树。
 * 你要找出这 n 棵树中，所有高度最小的树，并返回它们的根节点。
 * 其中，高度的定义是：根节点和最远的叶子节点之间，边的数量。
 *
 * 思路：
 * 1. DFS，暴力解法
 * 2. 找到无环无向图的中心
 * 3. DP
 */
public class LeetCode_310 {

    // Time: O(n ^ 2), Space: O(n), Faster: Time Limit Exceeded
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n <= 1 || edges == null) return Collections.singletonList(0);

        // 1. 构建图
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n]; // 用于是否被访问过
        int[] heights = new int[n];         // 用于记录从某个节点出发，得到的最高高度
        int[] max = new int[]{0};           // 用于地址传参
        int minHeight = Integer.MAX_VALUE;

        // 2. 遍历每个节点
        for (int i = 0; i < n; ++i) {
            // 访问图
            dfs(g, visited, i, 0, max);
            heights[i] = max[0];
            if (heights[i] < minHeight) minHeight = heights[i];
            max[0] = 0;
        }

        // 3. 求结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (heights[i] == minHeight) result.add(i);
        }
        return result;
    }

    private void dfs(List<List<Integer>> g, boolean[] visited,
                     int node, int dist, int[] max) {
        visited[node] = true;
        if (dist > max[0]) max[0] = dist;
        for (int v : g.get(node)) {
            if (!visited[v]) dfs(g, visited, v, dist + 1, max);
        }
        visited[node] = false;
    }

    // Time: O(n), Space: O(n), Faster: 80.51%
    public List<Integer> findMinHeightTreesShrink(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        // 1. 构建图：邻接表
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        // 2. 统计每个节点的度
        int[] degree = new int[n];
        LinkedList<Integer> leaves = new LinkedList<>(); // 叶节点，度为1的点
        for (int i = 0; i < n; ++i) {
            degree[i] = g.get(i).size();
            if (degree[i] == 1) leaves.add(i);
        }

        // 3. 遍历
        while (leaves.size() < n) {
            int size = leaves.size();
            n -= size;
            for (int i = 0; i < size; ++i) {
                int leaf = leaves.poll();
                for (int v : g.get(leaf)) {
                    --degree[v];
                    if (degree[v] == 1) leaves.add(v);
                }
            }
        }
        return leaves;
    }
}
