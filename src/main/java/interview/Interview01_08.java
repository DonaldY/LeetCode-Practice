package interview;

/**
 * @author donald
 * @date 2022/09/30
 *
 * 面试题 01.08. 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 题意： 清零判断, 需要记录原先 0 的位置
 *
 * 思路：
 * 1. 暴力法： 二维标记变量记录 0， 一个个判断
 * 2. 暴力法： 用 2 个一维数组记录 0
 * 3. 在方法二上： 用原数组的第一列和第一行来记录 0， 用 2个 变量来标识是否为 0
 */
public class Interview01_08 {

    // 方法一： 暴力法
    // Time: O(nm), Space: O(nm), Faster: 43.66%
    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return;
        boolean [][] flagMatrix = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    flagMatrix[i][j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                // 原始的值为0, 而不是后来被赋予的
                if (flagMatrix[i][j]) {
                    for (int k = 0; k < matrix.length; ++k) matrix[k][j] = 0;
                    for (int k = 0; k < matrix[0].length; ++k) matrix[i][k] = 0;
                }
            }
        }
    }

    // 方法二： 暴力法， 一维数组
    // Time: O(nm), Space: O(n), Faster: 100.00%
    public void setZeroes2(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return;
        boolean [] flagCol = new boolean[matrix[0].length];
        boolean [] flagRow = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    flagCol[j] = flagRow[i] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (flagCol[j] || flagRow[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 方法三： 2个变量
    // Time: O(nm), Space: O(1), Faster: 100.00%
    public void setZeroes3(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return;
        boolean flagCol = false, flagRow = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                flagCol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) {
                flagRow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[0][i] = 0;
            }
        }
    }
}
