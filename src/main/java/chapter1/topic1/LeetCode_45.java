package chapter1.topic1;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * 题意： 跳到数组末尾，最小步数
 *
 * 思路：
 * 1. 把每种解都求得一遍，找出对小。枚举法
 *    Time Limit Exceeded, 容易爆栈
 *
 * 2. 下标法
 *    在可达坐标下，添加步长数
 *
 * 3. 下标法（减空间复杂度）
 *
 */
public class LeetCode_45 {

    public int jump(int[] nums) {

        return jumpStep(0, nums, nums.length - 1, 0);
    }

    // Time: o(n ^ 2), Space: o(1)
    private int jumpStep(int i, int[] nums, int min, int step) {

        if (i >= nums.length - 1) return step;

        if (min <= step) return step;

        int num = nums[i];

        for (int j = num; j >= 1; --j) {

            min = Math.min(min, jumpStep(i + j, nums, min, step + 1));
        }

        return min;
    }

    // Time: o(n), Space: o(n), Faster: 48.30%
    public int numOfJumpToLast(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length, max = 0; // 最远可达的下标
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            if (max >= n - 1) return d[n - 1];
            if (i > max) return  -1;
            max = Math.max(max, i + nums[i]);
            int last = Math.min(max, n - 1);
            for (int j = last; j > i && d[j] == 0; --j) {
                d[j] = d[i] + 1;
            }
        }
        return -1;
    }

    // Time: o(n), Space: o(1), Faster: 99.99%
    public int numOfJumpToLast01(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int n = nums.length, max = 0, jumps = 0, currEnd = 0;
        for (int i = 0; i < n; ++i) {
            if (max >= n - 1) return jumps + 1;
            if (i > max) return  -1;
            if (i > currEnd) {
                ++jumps;
                currEnd = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return -1;
    }

    // Time: o(n), Space: o(1), Faster: 96.35%
    public int jumpOther(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        // 站在索引i，最多能跳到索引 end
        int end = 0;
        // 从索引 [i..end] 起跳，最远能跳到的距离
        int farthest = 0;
        // 记录跳跃次数
        int jumps = 0;
        for (int i = 0; i < n - 1; ++i) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                ++jumps;
                end = farthest;
            }
        }
        return jumps;
    }
}
