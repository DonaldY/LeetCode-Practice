package chapter2.topic1;

/**
 * 221. Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * 题意： 找到最大的正方形面积
 *
 * 思路：
 * 1. 在 Leetcode 85上， 选择最小的然后相乘
 *
 * 2. 看似求解最长边长，然后用动态规划来求解 dp
 *
 */
public class LeetCode_221 {

    // Time: O(m * n), Space: O(n), Faster: 99.64%
    public int maximalSquare(char[][] matrix) {

        return maximalSquare(matrix);
    }

    private int maximalSquareInternal(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int [] heights = new int[n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n ; ++j) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            max = Math.max(max, largestSquareleHistogram(heights));
        }
        return max;
    }

    private int largestSquareleHistogram(int [] heights) {
        int max = 0, n = heights.length, top = -1;
        int [] st = new int[n + 1];
        for (int r = 0; r <= n; ++r) {
            int h = r == n ? 0 : heights[r];
            while (top != -1 && h < heights[st[top]]) {
                int idx = st[top --];
                int l = top == -1 ? -1 : st[top];
                max = Math.max(max, (int) Math.pow((double) Math.min(heights[idx], (r - l - 1)), 2));
            }
            st[++top] = r;
        }
        return max;
    }

    // Time: O(n * m), Space: O(n * m), Faster: 95.79%
    public int maximalSquareDP(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
         matrix[0] == null || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int [][] d = new int[m][n];
        int len = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || matrix[i][j] == '0')
                    d[i][j] = matrix[i][j] == '1'? 1 : 0;
                else
                    d[i][j] = min(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1] + 1);
                len = Math.max(len, d[i][j]);
            }
        }
        return len * len;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
