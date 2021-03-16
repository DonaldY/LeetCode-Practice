package chapter1.topic2;

/**
 * @author donald
 * @date 2021/03/16
 *
 * LeetCode 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * ```
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * ```
 *
 * 题意： 给一个数，生成对应的大小的螺旋矩阵
 *
 * 可以参考 LeetCode 54
 *
 * 思路：
 * 1. 如何遍历？ 按题意，螺旋遍历
 * 2. 终止条件是什么？ 所有值被访问过
 * 3. 如何直接停止访问呢？ 设置边界
 *
 * 注意边界
 */
public class LeetCode_59 {

    // Time: O(n * n), Space: O(1), Faster: 100.00%
    public int[][] generateMatrix(int n) {

        if (n <= 0) return new int[0][0];

        int[][] matrix = new int[n][n];

        int top = 0, bottom = n, left = 0, right = n;
        int autoNum = 1;

        while (left < right) {

            // 从左到右
            for (int i = left; i < right; ++i) matrix[top][i] = autoNum ++;
            if (++top >= bottom) break;

            // 从上到下
            for (int i = top; i < bottom; ++i) matrix[i][right - 1] = autoNum ++;
            if (--right <= left) break;

            // 从右到左
            for (int i = right - 1; i >= left; --i) matrix[bottom - 1][i] = autoNum ++;
            if (--bottom <= top ) break;

            // 从下到上
            for (int i = bottom - 1; i >= top; --i) matrix[i][left] = autoNum ++;
            if (++left >= right) break;
        }
        return matrix;
    }
}
