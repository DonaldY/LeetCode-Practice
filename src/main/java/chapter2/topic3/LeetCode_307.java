package chapter2.topic3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/04/04
 *
 * 307. 区域和检索 - 数组可修改
 *
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 *
 * 题意：执行两个操作：
 * 1. 更新
 * 2. 求范围
 *
 * 思路：
 * 1. 正常思路： 但会超时
 * 2. 树状数组：
 * 3. 线段树： 暂不考虑
 */
public class LeetCode_307 {

    // Time: O(logn), Space: O(n), Faster: 99.29%
    class NumArray {

        // indexTree：树状数组
        private final int[] nums, indexTree;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            indexTree = new int[n+1];
            // 根据原始数组nums构建树状数组indexTree：调用add函数构建
            for (int i = 1; i <= n; i++) add(i, nums[i-1]);
        }

        public void update(int index, int val) {
            add(index+1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return preSum(right+1) - preSum(left);
        }

        // 在indexTree的index位置增加val
        private void add(int index, int val) {
            for (int i = index; i < indexTree.length; i += lowbit(i)) {
                indexTree[i] += val;
            }
        }

        private int preSum(int i) {
            int sum = 0;
            for (; i > 0; i -= lowbit(i)) {
                sum += indexTree[i];
            }
            return sum;
        }

        // 找到x的二进制数的最后一个1所表示的二进制
        private int lowbit(int i) {
            return i & (-i);
        }
    }
}
