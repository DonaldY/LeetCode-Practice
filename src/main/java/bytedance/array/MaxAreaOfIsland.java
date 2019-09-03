package bytedance.array;

/**
 * 数组与排序 - 岛屿的最大面积
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 题意：
 *
 * 思路：
 * 1. DFS
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int max = 0;

        for (int i = 0; i < grid.length; ++i) {

            for (int j = 0; j < grid[0].length; ++j) {

                if (grid[i][j] == 1) {

                    int islands = findMaxIsland(grid, i, j);

                    max = Math.max(max, islands);
                }
            }
        }

        return max;
    }

    private int findMaxIsland(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;

        if (grid[x][y] == 1) grid[x][y] = 0;
        else return 0;

        return 1 + findMaxIsland(grid, x + 1, y) + findMaxIsland(grid, x - 1, y) +
        findMaxIsland(grid, x, y - 1) + findMaxIsland(grid, x, y + 1);
    }
}
