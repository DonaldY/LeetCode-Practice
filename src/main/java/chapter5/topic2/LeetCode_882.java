package chapter5.topic2;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/11/26
 */
public class LeetCode_882 {
    static int N = 3010, INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] vis = new boolean[N];

    // Time: O(), Space: O(), Faster:
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // 建图
        for (int i = 0; i < n; i++) Arrays.fill(g[i], INF);
        for (int[] info : edges) {
            int a = info[0], b = info[1], c = info[2] + 1;
            g[a][b] = g[b][a] = c;
        }
        // 朴素 Dijkstra
        Arrays.fill(dist, INF);
        Arrays.fill(vis, false);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            vis[t] = true;
            for (int j = 0; j < n; j++) dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }
        // 统计答案
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) ans++;
        }
        for (int[] info : edges) {
            int a = info[0], b = info[1], c = info[2];
            int c1 = Math.max(0, maxMoves - dist[a]), c2 = Math.max(0, maxMoves - dist[b]);
            ans += Math.min(c, c1 + c2);
        }
        return ans;
    }
}
