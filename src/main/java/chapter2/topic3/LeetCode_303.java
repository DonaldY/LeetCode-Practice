package chapter2.topic3;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 不可变数组的区间和查询
 *
 * 这个题目说的是，给你一个不为空的整数数组，你要设计一个类，可以高效地查询数组中下标从 i 到 j 的区间和。

 * 注意，你可以假设数组一旦给你，就不会发生改变。并且给你的 i 和 j 一定是合法的下标，总是可以求出有效的区间和。另外，求区间和的函数会被频繁调用。
 *
 * 比如说，给你的数组 a 是：
 *
 * -1, 0, 4, -2, 8
 *
 * 假设计算区间和的函数是 f，那么有：
 *
 * f(0, 1) = -1 + 0 = -1
 * f(1, 3) = 0 + 4 + (-2) = 2
 *
 *
 */
public class LeetCode_303 {

    // Faster: 16.79%
    class NumArray {

        int [] arr;
        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; ++i) {
                sum += arr[i];
            }
            return sum;
        }
    }

    // Faster: 100.00%
    public class NumArrayImmutable {

        private final int[] prefixSum;

        public NumArrayImmutable(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 1; i < prefixSum.length; ++i)
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        public int sumRange(int i, int j) {
            return prefixSum[j + 1] - prefixSum[i];
        }
    }
}
