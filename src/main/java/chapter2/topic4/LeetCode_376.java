package chapter2.topic4;

import java.util.Stack;

/**
 * @author donald
 * @date 2022/08/21
 *
 * 最长摆动子序列的长度
 *
 * 这个题目说的是，对于一个整数序列，如果从左到右序列中元素值的相对大小交替变化，则把这个序列叫做摆动序列。
 * 如果一个序列不是摆动序列，那么总是可以通过删掉部分元素，来得到一个摆动子序列。
 * 现在给你一个整数序列，你要计算出最长摆动子序列的长度。
 *
 * 注意，单个元素的序列也是摆动序列。
 *
 * 比如说，给你的整数序列是:
 *
 * 1, 4, 2, 8, 0, 2
 *
 * 这个序列是一个摆动序列，直接返回它的长度 6 即可。
 *
 * 如果给你的序列变成：
 *
 * 1, 4, 6, 8, 0, 2
 *
 * 这个序列不是摆动序列，但是删掉 4 和 6 后，可以得到一个最长摆动子序列：
 *
 * 1, 8, 0, 2
 *
 * 因此你要返回的长度就为 4。
 *
 *
 * 思路：
 * 1. 栈： 保存上一个数
 *        - 当前值 < 栈顶元素 且 当前值 < 下一个值， 入栈
 *        - 当前值 > 栈顶元素 且 当前值 > 下一个值， 入栈
 *    注意： 元素个数为 2 时
 */
public class LeetCode_376 {

    // 方法一： 栈
    // Time: O(n), Space: O(n), Faster: 100.00%
    public int wiggleMaxLength(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        for (int i = 1; i <= nums.length - 2; ++i) {
            int pre = stack.peek();
            if (nums[i] > pre && nums[i] > nums[i + 1]) stack.add(nums[i]);
            else if (nums[i] < pre && nums[i] < nums[i + 1]) stack.add(nums[i]);
        }
        if (stack.peek() != nums[nums.length - 1]) {
            stack.add(nums[nums.length - 1]);
        }
        return stack.size();
    }

    // 方法二： 贪心
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int wiggleMaxLengthGreedy(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 1, len = 1;
        while (i < n && nums[i] == nums[i-1]) ++i;
        while (i < n) {
            if (nums[i] > nums[i-1]) ++len;
            while (i < n && nums[i] >= nums[i-1]) ++i;
            if (i < n) ++len;
            while (i < n && nums[i] <= nums[i-1]) ++i;
        }
        return len;
    }

    // 方法三： DP
    // Time: O(n), Space: O(n), Faster:
    public int wiggleMaxLengthDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1], down[n-1]);
    }
}
