package chapter2.topic4;

import java.util.Random;

/**
 * 384. Shuffle an Array
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * 题意： shuffle函数能把数组随机打乱，reset函数能返回初始数组
 *
 * 思路：
 * 1. 伪随机
 * 2. Fisher–Yates 洗牌
 *    依次遍历列表中的每一位，并将这一位与其后面的随机一位交换顺序。
 * 3. 水塘抽样
 *    依次遍历列表中的每一位，并将这一位与其后面的随机一位交换顺序。
 */
public class LeetCode_384 {

    private Random random = new Random();

    void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int [] shuffle(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            int j = random.nextInt(i + 1);
            swap(nums, i, j);
        }
        return nums;
    }
}

// Time: o(n), Space: o(n), Faster: 35.46%
class Solution {

    private int[] nums;
    private int[] originalNums;

    public Solution(int[] nums) {

        this.nums = nums;
        this.originalNums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return originalNums;
    }

    /** Returns a random shuffling of the array. */
    private Random random = new Random();

    void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int [] shuffle() {

        nums = originalNums.clone();

        for (int i = nums.length - 1; i > 0; --i) {
            int j = random.nextInt(i + 1);
            swap(nums, i, j);
        }
        return nums;
    }
}
