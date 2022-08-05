package chapter3.topic3;

import java.util.regex.Pattern;

/**
 * @author donald
 * @date 2022/08/05
 *
 * 省份数量
 * 这个题目说的是，给你 0 到 n-1 共 n 个城市，城市之间有的相互连接，有的则不相连。如果城市 0 与城市 1 直接相连，城市 1 与城市 2 直接相连，那么城市 0 与城市 2 称为间接相连。
 *
 * 直接相连或间接相连的一组城市定义为一个省份。现在给你一个 n x n 的矩阵 a 表示城市之间的连接情况。a(i, j) 等于 1 表示第 i 个城市和第 j 个城市直接相连，a(i, j) 等于 0 则表示这两个城市不直接相连。你要计算出，这 n 个城市一共构成了多少个省份。
 *
 * # 比如说，给你 3 个城市：
 * 0, 1, 2
 *
 * # 它们对应的连接矩阵 a 是：
 * 1, 0, 0
 * 0, 1, 1
 * 0, 1, 1
 *
 * # 根据这个矩阵，我们可以知道城市 0 不与城市 1 或城市 2 相连，它自成一个省份。城市 1 与城市 2 相互连接，构成一个省份。
 *
 * # 因此，这 3 个城市构成了 2 个省份。
 *
 *
 * 思路：
 * 1. 暴力法： dfs
 * 2. 并查集： 只需要看 parent[x] == x 有几个
 */
public class LeetCode_547 {

    public class UnionFind {

        private int[] parent, size;
        private int cnt; // 统计省数量

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            cnt = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        // Time: O(a(n)), Space: O(1)
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;
            if (size[xRoot] < size[yRoot]) {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            } else {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            }
            --cnt; // 每合并一次，说明能省的 -1
        }

        public int count() {
            // 或者看 parent[x] == x 有几个
            return cnt;
        }
    }

    // 方法一： 并查集
    // Time: O(n^2), Space: O(n), Faster: 86.14%
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 ||
                isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        // 1. 初始化并查集
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        // 2. 构建并查集
        for (int i = 0; i < n; ++i) {
            // 2.1 查看 i 和 j 是否相连
            for (int j = i + 1; j < n; ++j) {
                // 2.2 相连就合并
                if (isConnected[i][j] == 1) uf.union(i, j);
            }
        }

        return uf.count();
    }

    // 方法二： 暴力法 DFS
    // Time: O(n^2), Space: O(n), Faster: 86.14%
    public int findCircleNumDFS(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 ||
                isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (!isVisited[i]) {
                ++ cnt;
                dfs(n, i, isConnected, isVisited);
            }
        }

        return cnt;
    }

    private void dfs(int n, int i, int[][] isConnected, boolean[] isVisited) {
        if (i >= n || i < 0) return;

        for (int j = 0; j < n; ++j) {
            if (j == i) continue;
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(n, j, isConnected, isVisited);
            }
        }
    }
}
