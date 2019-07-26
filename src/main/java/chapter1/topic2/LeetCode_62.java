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

}
