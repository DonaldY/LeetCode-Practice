package chapter1.topic2;

/**
 * 74. Search a 2D Matrix
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * 题意：查找对应的数
 *
 * 思路：
 * 1. 将二维转换为一维，Z字走法
 */
public class LeetCode_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return false;

        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int i = mid / m, j = mid % n;
            if (mid == matrix[i][j]) {

                return true;
            }
            if (mid < matrix[i][j]) high = mid - 1;
            if (mid > matrix[i][j]) low = mid + 1;
        }

        return false;
    }
}
