package chapter1.topic2;

/**
 * 62. Unique Paths
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 *
 * 题意： 从左上走到右下有多少种不同的走法
 * m 是列， n 是行
 *
 * 思路：
 * 1. DFS，递归方式
 * 2. 动态规划题
 *    d(0, j) = 1
 *    d(i, 0) = 1
 *    d(i, j) = d(i - 1) + d(i, j - 1)
 *
 * 3. 排列组合题
 *
 */
public class LeetCode_62 {

    private int totalNum = 0;

    // Time: o(n), Space:o(n), Faster: Time Limit Exceeded
    public int uniquePaths(int m, int n) {

        if (m == 1 && n == 1) return 1;

        int row = 1, col = 1;

        findStar(col + 1, row, m, n);
        findStar(col, row + 1, m, n);

        return totalNum;
    }

    private void findStar(int col, int row, int m, int n) {

        if (col > m || row > n) return;

        if (col == m && row == n) {

            ++this.totalNum;
            return;
        }

        findStar(col + 1, row, m, n);
        findStar(col, row + 1, m, n);
    }

    // Time: o(m*n), Space: o(m*n), Faster: 100.00%
    public int uniquePathsDP(int m, int n) {

        if (m < 1 || n < 1) return 0;
        int [][] d = new int[m][n];
        for (int i = 0; i < m; ++i) {
            d[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            d[0][j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                d[i][j] = d[i -1][j] + d[i][j -1];
            }
        }
        return d[m-1][n-1];
    }

    // Time: O(min(m, n)), Space: O(1)
    public int uniquePathsMath(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int small = Math.min(m-1, n-1);
        int total = m + n - 2;
        long result = 1;
        for (int i = 0; i < small; ++i)
            result = result * (total-i) / (i+1);
        return (int)result;
    }

}
