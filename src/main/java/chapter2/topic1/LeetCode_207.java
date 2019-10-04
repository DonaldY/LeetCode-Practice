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
 * 1. 一个个查询（DFS），然后删除
 * 2. 利用图，走一圈，没有发现回路即可
 * 3. 拓扑排序
 */
public class LeetCode_207 {

    // Time: O(V + E), Space: O(V + E), Faster: 89.95%
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

        if (numCourses <= 1 || prerequisites == null) return true;

        List<List<Integer>> graph = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; ++i)
            graph.add(new LinkedList<>());

        for (int [] pair: prerequisites)
            graph.get(pair[1]).add(pair[0]);

        boolean[] checked = new boolean[numCourses];
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
}
