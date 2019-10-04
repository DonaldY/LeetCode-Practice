package chapter2.topic1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * 题意： 拓扑排序，返回可能的有序列表
 *
 * 思路：
 * 1. 拓扑排序，出度和入度
 */
public class LeetCode_210 {

    // Time: O(V + E), Space: O(V + E), Faster: 80.56%
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 1 || prerequisites == null)
            return new int[]{0};

        int [] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            graph.add(new LinkedList<>());

        for (int [] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            ++inDegree[pair[0]];
        }

        Queue<Integer> q = new LinkedList<>();
        int [] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < inDegree.length; ++i)
            if (inDegree[i] == 0) {
                q.add(i);
                result[index ++] = i;
            }

        if (index == numCourses) return result;

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            ++count;
            for (int i : graph.get(v)) {
                --inDegree[i];
                if (inDegree[i] == 0) {
                    q.add(i);
                    result[index ++] = i;
                }
            }
        }

        if (count == numCourses) return result;

        return new int[0];
    }
}
