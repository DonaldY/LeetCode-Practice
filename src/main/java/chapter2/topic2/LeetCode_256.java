package chapter2.topic2;

/**
 * @author donald
 * @date 2022/08/24
 *
 * 粉刷房子
 *
 * 这个题目说的是，你要用红/蓝/绿三种不同的颜色去粉刷 n 个房子，一个房子只能刷成一种颜色，并且相邻的房子不能粉刷相同的颜色。
 *
 * 现在给你一个 nx3 的费用矩阵，表示每个房子刷成红/蓝/绿 3 种颜色对应的费用。
 * 你要计算出，粉刷这 n 个房子的最小费用。注意，矩阵中的费用都为正整数。
 *
 *
 * 比如说，给你的费用矩阵 a 是：
 *
 * 8 2 4
 * 5 7 3
 * 9 1 6
 * 4 1 9
 *
 * 对于这个例子，你要将 0 号房子刷成蓝色，将 1 号房子刷成绿色，将 2 号房子刷成蓝色，将 3 号房子刷成红色。
 *
 * 最后得到的最小费用是 2 + 3 + 1 + 4 = 10。
 *
 *     r  b  g
 * 0   8  2  4
 * 1   5  7  3
 * 2   9  1  6
 * 3   4  1  9
 *
 * 0 号房子选 b颜色，代价 2
 * 1 号房子选 g颜色，代价 3
 * 2 号房子选 b颜色，代价 1
 * 3 号房子选 r颜色，代价 4
 *
 * 所以最小费用是 2 + 3 + 1 + 4 = 10。
 *
 *
 * 思路：
 * 1. 动态规划：
 */
public class LeetCode_256 {

    // Time: O(n), Space: O(n)
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] d = new int[n][3];
        d[0][0] = costs[0][0];
        d[0][1] = costs[0][1];
        d[0][2] = costs[0][2];

        for (int i = 1; i < n; ++i) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + costs[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + costs[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + costs[i][2];
        }
        return min(d[n-1][0], d[n-1][1], d[n-1][2]);
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
