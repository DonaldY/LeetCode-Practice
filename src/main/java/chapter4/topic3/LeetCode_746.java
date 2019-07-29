package chapter4.topic3;

/**
 * 746. Min Cost Climbing Stairs
 *
 *
 * 题意：
 * 给你一个整数数组，数组中的整数表示爬对应阶楼梯的代价。
 * 你可以从第 0 阶或第 1 阶楼梯开始爬，每次可以向上爬 1 阶或 2 阶。
 * 那么请问，爬完这个楼梯的最小代价是多少？
 *
 * 思路：
 * DP
 *
 * d(i) = min(d(i - 1), d(i - 2)) + c(i)
 * d(0) = c(0), d(1) = c(1)
 */
public class LeetCode_746 {

    // Time: o(n), Space: o(n), Faster: 99.88%
    public int minCostClimbingStairs(int [] cost) {

        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int n = cost.length;
        int [] d = new int[n];
        d[0] = cost[0];  d[1] = cost[1];

        for (int i = 2; i < n; ++i) {
            d[i] = Math.min(d[i - 1], d[i - 2]) + cost[i];
        }

        return Math.min(d[n - 2], d[n - 1]);
    }

    // Time: o(n), Space: o(n), Faster: 100.00%
    public int minCostClimbingStairs01(int [] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int first = cost[0], second = cost[1];

        for (int i = 2; i < cost.length; ++i) {
            int cur = Math.min(first, second) + cost[i];
            first = second;
            second = cur;
        }

        return Math.min(first, second);
    }
}
