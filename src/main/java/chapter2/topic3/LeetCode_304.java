package chapter2.topic3;

/**
 * @author donald
 * @date 2021/03/02
 *
 * LeetCode 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * ```
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * ```
 *
 * 题意： 求矩阵中子矩阵的和
 *
 * 思路：
 * 1. 暴力求法，每次都求一遍
 * 2. 前缀和，求出每一行的前缀和，然后做减
 */
public class LeetCode_304 {

    // Faster: 98.81%
    class NumMatrix {

        int[][] matrix;
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {

                for (int j = 1; j <= n; j++) {

                    //注意是matrix[i-1][j-1]
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1]
                    - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }

    public class NumMatrixImmutable {

        private final int[][] prefixSum;

        public NumMatrixImmutable(int[][] matrix) {
            if (matrix == null || matrix.length == 0
                    || matrix[0] == null || matrix[0].length == 0) {
                prefixSum = new int[1][1];
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            prefixSum = new int[m+1][n+1];
            for (int i = 1; i <= m; ++i)
                for (int j = 1; j <= n; ++j)
                    prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j]
                            - prefixSum[i-1][j-1] + matrix[i-1][j-1];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2+1][col2+1] - prefixSum[row2+1][col1]
                    - prefixSum[row1][col2+1] + prefixSum[row1][col1];
        }

    }
}
