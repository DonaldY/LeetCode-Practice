package chapter1.topic2;

import java.util.Stack;

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
 * 1. 暴力法： 从两边扩散
 * 2. 辅助栈维护一个下标序列，这些下标对应的直方图高度依次递增。
 *    当 r 对应的高度小于栈顶下标对应的高度时，对于栈顶下标对应的高度来说：
 *    - 下标 r 是它的右边界
 *    - 栈顶的前一个元素是它的左边界
 *
 *    面积：高×宽
 *    宽度计算公式： r - l -1
 * 3. 数组代替栈
 */
public class LeetCode_84 {

    public static void main(String[] args) {

        LeetCode_84 leetCode_84 = new LeetCode_84();

        int area = leetCode_84.largestRectangleAreaStack(new int[] {2});

        System.out.println(area);
    }

    // 方法一：暴力法, 超时
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

    // 方法二：用栈模拟
    // 宽度计算公式： r - l -1
    // Time: O(n), Space: O(n), Faster: 16.07%
    public int largestRectangleAreaStack(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0, n = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int r = 0; r <= n; ++r) {
            int h = r == n ? 0 : heights[r]; // 0 高度最小
            while (!st.empty() && h < heights[st.peek()]) {
                int idx = st.pop();
                int l = st.empty() ? -1 : st.peek(); // 注意：-1 特殊值
                max = Math.max(max, heights[idx] * (r - l - 1));
            }
            st.push(r);
        }
        return max;
    }

    // 方法三：用数组模拟栈
    // Time: O(n), Space: O(n), Faster: 99.32%
    public int largestRectangleAreaArray(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0, n = heights.length, top = -1;
        int[] st = new int[n + 1];
        for (int r = 0; r <= n; ++r) {
            int h = r == n ? 0 : heights[r];
            while (top != -1 && h < heights[st[top]]) {
                int idx = st[top--];
                int l = top == -1 ? -1 : st[top];
                max = Math.max(max, heights[idx] * (r - l - 1));
            }
            st[++top] = r;
        }
        return max;
    }
}
