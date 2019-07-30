package chapter2.topic2;

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
 *
 * 状态 d(i) 表示以第 i 个数字结尾的最长递增子序列的长度
 *
 * d(i) = max(d(j)+1), a(i) > a(j)
 *
 * 2. DP 保存结尾最小的数字
 */
public class LeetCode_300 {

    public int lengthOfLIS(int[] nums) {
        return 0;
    }

    // Time: o(n^2), Space: o(n), Faster:
    public int lengthOfLISDP(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 1;
        int [] d = new int[n];
        d[0] = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int cur = nums[i] > nums[j] ? d[j] + 1 : 1;
                d[i] = Math.max(d[i], cur);
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    private int binarySearchInsertPosition(int[] d, int len, int x) {
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x < d[mid]) high = mid - 1;
            else if (x > d[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }

    // Time: o(n * log(n)), Space: o(n)
    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, len = 0;
        int [] d = new int[n];
        for (int x : nums) {
            int i = binarySearchInsertPosition(d, len, x);
            d[i] = x;
            if (i == len) ++len;
        }
        return len;
    }
}
