package chapter1.topic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 题意： 旋转输出数组的数值
 *
 * 思路：
 * 1. 如何遍历？ 按题意，螺旋遍历
 * 2. 终止条件是什么？ 所有值被访问过
 * 3. 如何直接停止访问呢？ 设置边界
 */
public class LeetCode_54 {

    // Time: O(m * n), Space: O(1), Faster: 100.00%
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null) return Collections.emptyList();

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        List<Integer> result = new ArrayList<>();

        while (left < right ) {

            for (int i = left; i < right; ++i) result.add(matrix[top][i]);
            if (++top >= bottom) break;

            for (int i = top; i < bottom; ++i) result.add(matrix[i][right - 1]);
            if (--right <= left) break;

            for (int i = right - 1; i >= left; --i) result.add(matrix[bottom - 1][i]);
            if (--bottom <= top) break;

            for (int i = bottom - 1; i >= top; --i) result.add(matrix[i][left]);
            if (++left >= right) break;
        }
        return result;
    }
}
