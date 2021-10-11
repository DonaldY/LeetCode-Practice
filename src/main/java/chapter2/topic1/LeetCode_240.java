package chapter2.topic1;

import java.util.Arrays;

/**
 * 240. Search a 2D Matrix II
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 * 题意： 查找矩阵中的数字
 *
 * Tips： 这道题目并不保证每一行的第一个数都比上一行的最后一个数要大。
 * so, 不能使用二分法
 *
 * 思路：
 * 1. 按最后一列查找，再按行查找
 *
 */
public class LeetCode_240 {

    public static void main(String[] args) {

        int [][] matrix = new int[][] {
                {1,  4,   7, 11, 15},
                {2,  5,   8, 12, 19},
                {3,  6,   9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int [][] matrix2 = new int[][] {
                {-5}
        };

        System.out.println(Arrays.deepToString(matrix));

        LeetCode_240 leetCode = new LeetCode_240();

        //System.out.println(leetCode.searchMatrix(matrix, 20));
        System.out.println(leetCode.searchMatrix(matrix2 , -5));
    }

    // Time: O(log(n)), Space: O(1), Faster: 100.00%
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0)
            return false;

        int columns = matrix[0].length; // 列数
        int rows = matrix.length;       // 行数

        int x = 0, y = columns - 1;

        while (x < rows && y >= 0) {

            if (target == matrix[x][y]) return true;

            if (target < matrix[x][y]) {

                --y;
            } else if (target > matrix[x][y]) {

                ++x;
            }
        }

        return false;
    }
}
