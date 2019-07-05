package chapter1.topic2;

/**
 * 64. Minimum Path Sum
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * 题意： 从坐上角，走到右下角，看哪条路最短
 *
 * 思路：
 * 1. DFS(每一个查询)
 * 2. DP(动态规划)
 *    d(i, j) 为最小的和
 *    d(m-1, n-1)即为答案
 *
 *    d(0, 0) = a(0, 0) [即这个位置本身的值]
 *    d(o, j) = d(0, j - 1) + a(0, j)
 *    d(i, 0) = d(i - 1, 0) + a(i, 0)
 *    d(i, j) = min(d(i-1, j), d(i, j-1)) + a(i, j)
 *
 * 3. DP 一维数组表示
 */
public class LeetCode_64 {

    // Time: o(m * n), Space: o(m * n), Faster: 90.23%
    public int minSumOfPath(int [][] grid) {
        int m = grid.length, n = grid[0].length;
        int [][] d = new int[m][n];

        d[0][0] = grid[0][0];

        for (int i = 1; i < m; ++i) {

            d[i][0] = d[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; ++j) {

            d[0][j] = d[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];

        return d[m-1][n-1];
    }

    // Time: o(m * n), Space: o(n), Faster: 99.61%
    public int minSumOfPath1dArray(int [][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] d = new int[n];

        d[0] = grid[0][0];

        for (int j = 1; j < n; ++j) {
            d[j] = d[j-1] + grid[0][j];
        }

        for (int i = 1; i < m; ++i) {
            d[0] += grid[i][0];
            for (int j = 1; j < n; ++j) {
                d[j] = Math.min(d[j], d[j - 1]) + grid[i][j];
            }
        }

        return d[n - 1];
    }

    private int sum = Integer.MAX_VALUE;

    // 方向只有向右或向左
    public int minPathSum(int[][] grid) {

        findMinPathSum(grid, 0, 0 , 0);

        return sum;
    }

    private void findMinPathSum(int[][] grid, int min, int x, int y) {

        if (x >= grid.length || y >= grid[0].length) return;

        min += grid[x][y];

        if (x == grid.length - 1 && y == grid[0].length - 1) {

            if (min < sum) sum = min;

            return;
        }

        findMinPathSum(grid, min, x + 1, y);

        findMinPathSum(grid, min, x, y + 1);
    }


}
