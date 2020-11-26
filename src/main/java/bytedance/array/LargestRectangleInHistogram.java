package bytedance.array;

/**
 * @author donald
 * @date 2020/11/25
 *
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * 思路：
 * 这道题与水容量那道不同，这道题中间有短个
 * 1. 穷举
 * 2. 栈方法
 */
public class LargestRectangleInHistogram {

    // Time: O(n^2), Space: O(1), Faster: 22.00%
    public int largestRectangleArea(int[] heights) {

        if (null == heights || heights.length == 0) return 0;

        int max = 0;

        for (int i = 0; i < heights.length; ++i) {

            int min = heights[i];

            if (max < heights[i]) max = heights[i];

            for (int j = i + 1; j < heights.length; ++j) {

                if (min > heights[j]) min = heights[j];

                int tmp = min * (j - i + 1);

                if (tmp > max) max = tmp;
            }
        }

        return max;
    }

    // Time: O(n), Space: O(1), Faster: 22.00%
    public int largestRectangleArea2(int[] heights) {

        if (null == heights || heights.length == 0) return 0;

        int max = 0;

        for (int i = 0; i < heights.length; ++i) {

            // 前面的加当前的 < 当前的， 则反转

        }

        return max;
    }
}
