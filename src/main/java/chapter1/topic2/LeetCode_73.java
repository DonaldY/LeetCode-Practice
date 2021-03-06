package chapter1.topic2;

/**
 * 73. Set Matrix Zeroes
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 题意：将矩阵中为0的行与列都置为0
 *
 * 思路：
 * 1. 两层for循环查询，并用两层for循环置
 * 2. 用另一个数组来报存是否置零，然后查询
 * 3. 使用一个标记变量: 对方法二进一步优化，只使用一个标记变量记录第一列是否原本存在 00。
 *    这样，第一列的第一个元素即可以标记第一行是否出现 00。
 *    但为了防止第一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
 *
 */
public class LeetCode_73 {

    public void setZeroes(int[][] matrix) {
    }

    // Time: o(m * n), Space: o(m + n), Faster: 100.00%
    public void setZeroInMatrix(int [][] a) {

        int m = a.length, n = a[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (a[i][j] == 0)
                    rows[i] = cols[j] = true;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rows[i] || cols[j])
                    a[i][j] = 0;
    }

    // Time: o(m * n), Space: o(1), Faster: 100.00%
    public void setZeroInMatrixO1(int [][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean row0 = false, col0 = false;

        for (int i = 0; i < m; ++i)
            if (matrix[i][0] == 0) col0 = true;

        for (int j = 0; j < n; ++j)
            if (matrix[0][j] == 0) row0 = true;

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (row0)
            for (int j = 0; j < n; ++j)
                matrix[0][j] = 0;

        if (col0)
            for (int i = 0; i < m; ++i)
                matrix[i][0] = 0;
    }

    // Time: O(m * n), Space: O(1), Faster: 99.91%
    public void setZeroesMatrix02(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
