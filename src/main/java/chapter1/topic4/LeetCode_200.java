package chapter1.topic4;

import java.util.Stack;

/**
 * 200. Number of Islands
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * 题意：
 * 求有多少个岛？
 *
 * 思路：
 * 1. DFS，遇到陆地则标记为水
 * 2. BFS
 */
public class LeetCode_200 {

    // Time: o(n * m), Space: o(1), Faster: 100.00%
    public int numIslands(char[][] grid) {

        if (grid == null) return 0;

        int result = 0;

        for (int i = 0; i < grid.length; ++i) {

            for (int j = 0; j < grid[0].length; ++j) {

                if (grid[i][j] == '1') {

                    findLands(grid, i, j);

                    ++result;
                }
            }
        }

        return result;
    }

    private void findLands(char[][] grid, int n, int m) {

        if (m >= grid[0].length || n >= grid.length || m < 0 || n < 0 || grid[n][m] == '0') return;

        grid[n][m] = '0';

        findLands(grid, n + 1, m);
        findLands(grid, n, m + 1);
        findLands(grid, n - 1, m);
        findLands(grid, n, m -1);
    }

    private void dfs(char[][] g, boolean[][] visit, int i, int j) {
        int m = g.length, n = g[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == '0' || visit[i][j])
            return;
        visit[i][j] = true;
        dfs(g, visit, i-1, j);
        dfs(g, visit, i+1, j);
        dfs(g, visit, i, j-1);
        dfs(g, visit, i, j+1);
    }

    // Time: O(m*n), Space: O(m*n)
    public int numberOfIslands(char[][] g) {
        if (g == null || g.length == 0 ||
                g[0] == null || g[0].length == 0)
            return 0;
        int m = g.length, n = g[0].length;
        boolean[][] visit = new boolean[m][n];

        int num = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g[i][j] == '0' || visit[i][j]) continue;
                ++num;
                dfs(g, visit, i, j);
            }
        }
        return num;
    }

    ////////////////////////    DFS Iterative    ////////////////////////
    private class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private void dfsIterative(char[][] g, boolean[][] visit, int i , int j) {
        int m = g.length, n = g[0].length;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j));
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (p.i < 0 || p.i >=m || p.j < 0 || p.j >= n || g[p.i][p.j] == '0' || visit[p.i][p.j])
                continue;
            visit[p.i][p.j] = true;
            stack.push(new Point(p.i-1, p.j));
            stack.push(new Point(p.i+1, p.j));
            stack.push(new Point(p.i, p.j-1));
            stack.push(new Point(p.i, p.j+1));
        }
    }

}
