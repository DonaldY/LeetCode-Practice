package chapter10.topic4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/12/19
 */
public class LeetCode_1971 {

    // Time: O(), Space: O(), Faster:
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (null == edges || edges.length == 0) return true;

        boolean[] flag = new boolean[n];

        return isValidPath(n, edges, source, destination, flag);
    }

    private boolean isValidPath(int n, int[][] edges, int source, int destination, boolean[] flag) {

        for (int i = 0; i < edges.length; ++i) {
            if (flag[i]) {

                continue;
            }
            if (edges[i][1] == destination) {

                return true;
            }
            flag[i] = true;
            boolean isValidPath = isValidPath(n, edges, edges[i][1], destination, flag);
            if (isValidPath) {
                return true;
            }
            flag[i] = false;
        }

        return false;
    }

    // BFS
    // Time: O(n + m), Space: O(n + m), Faster: 100%
    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == destination) {
                break;
            }
            for (int next : adj[vertex]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }
}
