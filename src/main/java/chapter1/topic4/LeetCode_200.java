package chapter1.topic4;

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

    // Time: o(n ^ 2), Space: o(1), Faster: 100.00%
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

}
