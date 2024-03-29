package chapter2.topic2;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 *
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * 题意： 找到最长递增子序列，子序列不要求连续
 *
 * 思路：
 * 1. DP
 *   状态 d(i) 表示以第 i 个数字结尾的最长递增子序列的长度
 *   d(i) = max(d(j)+1), a(i) > a(j)
 *
 * 2. DP 保存结尾最小的数字， 例如蜘蛛纸牌
 */
public class LeetCode_300 {

    // Time: O(n^2), Space: O(n), Faster: 15.08%
    public int lengthOfLIS(int[] nums) {

        int [] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {

                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;

        for (int value : dp) {

            result = Math.max(result, value);
        }

        return result;
    }

    // Time: o(n^2), Space: o(n), Faster: 27.93%
    public int lengthOfLISDP(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 1;
        int [] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int cur = nums[i] > nums[j] ? dp[j] + 1 : 1;
                dp[i] = Math.max(dp[i], cur);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Time: o(n * log(n)), Space: o(n), Faster:  99.60%
    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 牌堆数初始化为 0
        int len = 0;
        int [] top = new int[nums.length];
        for (int x : nums) {
            int left = binarySearchInsertPosition(top, len, x);
            // 把这张牌放到牌堆顶
            top[left] = x;
            // 没找到合适的牌堆，新建一堆
            if (left == len) ++len;
        }
        return len;
    }

    private int binarySearchInsertPosition(int[] d, int len, int x) {
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x < d[mid]) right = mid - 1;
            else if (x > d[mid]) left = mid + 1;
            else return mid;
        }
        return left;
    }
}
