package chapter2.topic2;

/**
 * @author donald
 * @date 2022/08/23
 *
 * K 种颜色粉刷房子
 * 这个题目说的是，你要用 k 种不同的颜色去粉刷 n 个房子，一个房子只能刷成一种颜色，并且相邻的房子不能粉刷相同的颜色。
 *
 * 现在给你一个 nxk 的费用矩阵，表示每个房子刷成 k 种颜色对应的费用。你要计算出，粉刷这 n 个房子的最小费用。注意，矩阵中的费用都为正整数。
 *
 * 比如说，给你的费用矩阵 a 是：
 *
 * 8 2 4
 * 5 7 3
 * 9 1 6
 * 4 1 9
 *
 * 对于这个例子，你要将 0 号房子刷成 1 号颜色，将 1 号房子刷成 2 号颜色，将 2 号房子刷成 1 号颜色，将 3 号房子刷成 0 号颜色。
 *
 * 最后得到的最小费用是 2 + 3 + 1 + 4 = 10。
 *
 *
 * 思路：
 * 1. DP
 *
 */
public class LeetCode_265 {

    // Time: O(n*k^2), Space: O(n*k)
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        if (k == 1) return costs[0][0];
        int[][] d = new int[n + 1][k];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < k; ++j) {
                int min = Integer.MAX_VALUE;
                for (int c = 0; c < k; ++c)
                    if (c != j)
                        min = Math.min(min, d[i - 1][c]);
                d[i][j] = min + costs[i - 1][j];
            }
        }
        int min = d[n][0];
        for (int i = 1; i < k; ++i)
            min = Math.min(min, d[n][i]);
        return min;
    }

    // Time: O(n*k), Space: O(n*k)
    public int minCostOpt(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        if (k == 1) return costs[0][0];
        int[][] d = new int[n + 1][k];
        int preIdx1 = 0, preIdx2 = 1;

        for (int i = 1; i <= n; ++i) {
            int idx1 = -1, idx2 = -1;
            for (int j = 0; j < k; ++j) {
                if (j != preIdx1) d[i][j] = d[i - 1][preIdx1] + costs[i - 1][j];
                else d[i][j] = d[i - 1][preIdx2] + costs[i - 1][j];

                if (idx1 < 0 || d[i][j] < d[i][idx1]) {
                    idx2 = idx1;
                    idx1 = j;
                } else if (idx2 < 0 || d[i][j] < d[i][idx2]) {
                    idx2 = j;
                }
            }
            preIdx1 = idx1;
            preIdx2 = idx2;
        }
        int min = d[n][0];
        for (int i = 1; i < k; ++i)
            min = Math.min(min, d[n][i]);
        return min;
    }

    // Time: O(n*k), Space: O(1)
    public int minCostO1(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        if (k == 1) return costs[0][0];
        int preMin1 = 0, preMin2 = 0;
        int preIdx1 = 0;

        for (int i = 1; i <= n; ++i) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int idx1 = -1;
            for (int j = 0; j < k; ++j) {
                int cost;
                if (j != preIdx1) cost = preMin1 + costs[i - 1][j];
                else cost = preMin2 + costs[i - 1][j];

                if (cost < min1) {
                    min2 = min1;
                    min1 = cost;
                    idx1 = j;
                } else if (cost < min2) {
                    min2 = cost;
                }
            }
            preMin1 = min1;
            preMin2 = min2;
            preIdx1 = idx1;
        }
        return preMin1;
    }
}
