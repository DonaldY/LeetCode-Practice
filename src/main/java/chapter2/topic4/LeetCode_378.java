package chapter2.topic4;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/08/06
 *
 * 这个题目说的是，给你一个 m x n 的矩阵，矩阵中的每一行都从左向右递增，每一列都从上到下递增。你要找出矩阵中第 K 小的元素。
 *
 * 注意，题目给你的 K 总是有效的。
 *
 * 比如说，给你的矩阵是：
 *
 * [
 *  [1, 5, 7],
 *  [2, 5, 8]
 * ]
 *
 * 给你的 K 等于 4：
 *
 * K = 4
 *
 * 在这个矩阵中，第 4 小的数字是 5，因此返回 5。
 *
 * 思路：
 * 1. 暴力法： 维护一个最大堆，遍历每个数
 * 2.
 */
public class LeetCode_378 {

    // Time: O(m*n*log(k)), Space: O(k), Faster: 14.29%
    public int kthSmallestMaxHeap(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (maxHeap.size() < k) {
                    maxHeap.add(matrix[i][j]);
                } else if (matrix[i][j] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }
}
