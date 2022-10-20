package chapter3.topic3;

import java.util.Random;

/**
 * @author donald
 * @date 2022/10/20
 *
 * 说是： 操作系统中彩票调度算法
 *
 * 思路：
 * 1. 操作系统中彩票调度算法
 * 2. 前缀和 + 二分搜索
 */
public class LeetCode_528 {

    // 方法一： 彩票调度算法
    // Faster: 6.23%
    class Solution {

        private int[] w;
        private int size;
        private Random random;

        public Solution(int[] w) {
            this.w = w;
            this.random = new Random();
            this.size = 0;
            for (int num : w) size += num;
        }

        public int pickIndex() {
            int num = random.nextInt(size);
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                sum += w[i];
                if (sum > num) return i;
            }
            return 0;
        }
    }

    // 方法二： 前缀和 + 二分搜索
    // Faster:74.80%
    class SolutionPre {

        private int[] preSum;
        private Random random;
        private int size;

        public SolutionPre(int[] w) {
            this.random = new Random();
            this.preSum = w.clone();  // 先复制一份
            for (int i = 1; i < w.length; ++i) {
                preSum[i] += preSum[i - 1];
            }
            this.size = preSum[w.length - 1];
        }

        // 找到第一个大于 随机值 的值
        public int pickIndex() {
            int ran = random.nextInt(size) + 1; // [1, size]
            int left = 0, right = preSum.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (preSum[mid] < ran) left = mid + 1;
                else if (preSum[mid] >= ran) right = mid;
            }
            return left;
        }
    }
}
