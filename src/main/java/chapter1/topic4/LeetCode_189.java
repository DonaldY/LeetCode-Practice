package chapter1.topic4;

import java.util.Stack;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 题意： 向右旋转
 *
 * 思路：
 * 1. 辅助栈，用于保存旋转的数
 * 2. 三次反转
 *    1. 整体反转
 *    2. 左边局部反转
 *    3. 右边局部反转
 *
 * Tips：K 数可能较大
 */
public class LeetCode_189 {

    // Time: o(n), Space: o(n), Faster: 36.74%
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) return;

        k = k % nums.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1 ; i >= nums.length - k; --i) {

            stack.push(nums[i]);
        }

        for (int i = nums.length - k - 1; i >= 0 ; --i) {

            nums[i + k] = nums[i];
        }

        int j = 0;
        while (!stack.isEmpty()) {

            nums[j ++] = stack.pop();
        }
    }

    // Time: o(n), Space: o(n), Faster: 99.11%
    public void rotateByCopy(int [] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) return;

        int n = nums.length, m = k % n, i = 0;

        int [] t = new int[n];

        for (int j = n - m; j < n; ++j) t[i++] = nums[j];
        for (int j = 0; j < n - m; ++j) t[i++] = nums[j];
        for (int j = 0; j < n; ++j) nums[j] = t[j];
    }

    // Time: o(n), Space: o(1), Faster: 100.00%
    public void rotateBySwap(int [] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;

        int n = nums.length, m = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}