package chapter1.topic1;

/**
 * @author donald
 * @date 2020/5/15
 *
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * 题意：
 * 这个题目说的是，给你一个整数数组，你要找到数组中没有出现的最小正整数。
 *
 * 这个题目要求算法只能使用 O(n) 的时间，以及 O(1) 的辅助空间。
 *
 *
 * 思路：
 * 1. 遍历两次数组
 *    1. 利用数组特性 下标从 0 ~ N-1, 对应值 1 ~ N
 *       把每个数字调整到对应的下标上，例如： 1 对应下标 0
 *    2. 再遍历一遍调整完的数组，找到第一个下标不对应的数字
 *
 *    原数组： 2 -1  4 1 8
 *    调整后： 1  2 -1 4 8
 *    这样就找到 3 了
 */
public class LeetCode_41 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) return 1;
        int n = nums.length, p = 0;
        while (p < n) {
            int num = nums[p];
            if (num >= 1 && num <= n && nums[num-1] != num) {
                swap(nums, p, num-1);
            } else ++p;
        }
        for (int i = 0; i < n; ++i)
            if (nums[i] != i+1)
                return i+1;
        return n+1;
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
