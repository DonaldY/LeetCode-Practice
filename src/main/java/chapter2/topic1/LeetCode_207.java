package chapter2.topic1;

import java.util.*;

/**
 * 207. Course Schedule
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * 题意： 要完成一个课程，必须把其前置课程完成，那么能不能完成这个可能呢？
 *       这有点像锁，循环等待.
 *       单向连通图
 *
 * 思路：
 * 1. 一个个查询（DFS） + 回溯 : 利用图，走一圈，没有发现回路即可
 * 2. 拓扑排序 : 入度 和 出度
 */
public class LeetCode_207 {

    // 方法一： dfs + 回溯
    // Time: O(V + E), Space: O(V + E), Faster: 64.27%
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

        if (numCourses <= 1 || prerequisites == null) return true;

        // 构建图： 构建邻接表
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new LinkedList<>());
        }
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        // 记录这个节点之后是否有环， true 无环 false 可能有环
        boolean[] checked = new boolean[numCourses];
        // 标记是否访问过
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i)
            if (!checked[i] && hasCycle(graph, visited, checked, i))
                return false;

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited,
                             boolean[] checked, int v) {

        if (visited[v]) return true;

        visited[v] = true;

        for (int i : graph.get(v)) {

            if (!checked[i] && hasCycle(graph, visited, checked, i))
                return true;
        }

        checked[v] = true;
        visited[v] = false;

        return false;
    }

    // 方法二： 拓扑排序
    // Time: O(V + E), Space: O(V + E), Faster: 39.75%
    public boolean canFinishTopSortAdjList(int numCourses, int[][] prerequisites) {

        if (numCourses <= 1 || prerequisites == null || prerequisites.length == 0)
            return true;

        // 记录每个节点的入度数
        int[] inDegree = new int[numCourses];

        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new LinkedList<>());
        }
        // 建立节点的关系
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            ++inDegree[pair[0]];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            ++count;
            for (int i : graph.get(v)) {
                --inDegree[i];
                if (inDegree[i] == 0) q.add(i);
            }
        }
        return count == numCourses;
    }
}
