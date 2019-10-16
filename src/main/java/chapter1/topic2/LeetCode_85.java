package chapter1.topic2;

/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * 题意： 找到最大矩形面积
 *
 * 思路：
 * 1. 146. 直方图中的最大矩形面积
 *
 */
public class LeetCode_85 {

    // Time: O(m * n), Space: O(n), Faster: 99.70%
    public int maximalRectangle(char[][] matrix) {
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
            max = Math.max(max, largestRectangleHistogram(heights));
        }
        return max;
    }

    private int largestRectangleHistogram(int [] heights) {
        int max = 0, n = heights.length, top = -1;
        int [] st = new int[n + 1];
        for (int r = 0; r <= n; ++r) {
            int h = r == n ? 0 : heights[r];
            while (top != -1 && h < heights[st[top]]) {
                int idx = st[top --];
                int l = top == -1 ? -1 : st[top];
                max = Math.max(max, heights[idx] * (r - l - 1));
            }
            st[++top] = r;
        }
        return max;
    }
}
