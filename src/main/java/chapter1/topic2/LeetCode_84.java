package chapter1.topic2;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * 题意： 个非负整数数组，数组中的整数表示直方图的高度，每个直方图的宽度都为 1，
 * 你要计算出直方图中最大矩形的面积。
 *
 * 思路：
 * 1. 暴力法
 * 2. 辅助栈维护一个下标序列，这些下标对应的直方图高度依次递增。
 *    当 r 对应的高度小于栈顶下标对应的高度时，对于栈顶下标对应的高度来说：
 *    - 下标 r 是它的右边界
 *    - 栈顶的前一个元素是它的左边界
 *
 */
public class LeetCode_84 {

    // Time: O(n), Space: O(1), Faster: 15.78%
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0, n = heights.length;
        for (int i = 0; i < n; ++i) {
            int l = i, r = i;
            while (l >= 0 && heights[l] >= heights[i]) --l;
            while (r < n && heights[r] >= heights[i]) ++r;
            max = Math.max(max, heights[i] * (r - l - 1));
        }
        return max;
    }
}
