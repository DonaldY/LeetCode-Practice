package chapter1.topic2;

/**
 * 63. Unique Paths II
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * 题意： 从左上走到右下，其中有阻挡，有几种走法
 *
 * 思路：
 * 1. DFS
 * 2.
 */
public class LeetCode_63 {

    // Time: o(m * n), Space: o(m * n), Faster: 100.00%
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int [][] d = new int[m][n];
        d[0][0] = obstacleGrid[0][0] == 1? 0 : 1;
        for (int i = 1; i < m; ++i)
            d[i][0] = obstacleGrid[i][0] == 1 ? 0 : d[i - 1][0];
        for (int j = 1; j < n; ++j)
            d[0][j] = obstacleGrid[0][j] ==  1 ? 0 : d[0][j - 1];

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                d[i][j] = obstacleGrid[i][j] == 1 ? 0 : d[i - 1][j] + d[i][j - 1];

        return d[m - 1][n - 1];
    }
}
