package bytedance.dp;

/**
 * 动态或贪心 - 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 题意： 求得最大正方形面积
 *
 * 思路：
 * 1. 暴力求法
 *    从左上开始遍历每一个节点， 到最后 [len][len]
 *    I.  判断是否每条边是否均为 1
 *    II. 求面积
 */
public class MaximalSquare {

    public int maximalSquareWithForce(char[][] matrix) {

        if (matrix == null || matrix.length == 0) return 0;

        int len = matrix.length, len2 = matrix[0].length;

        return 0;
    }
}
