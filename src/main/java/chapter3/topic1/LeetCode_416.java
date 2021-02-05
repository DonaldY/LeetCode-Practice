package chapter3.topic1;

/**
 * @author donald
 * @date 2021/02/05
 *
 * `LeetCode 416`. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * ```
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * ```
 *
 * 思路：
 * 1. 背包 dp
 */
public class LeetCode_416 {

    // Time: O(n * sum), Space: O(sum), Faster: 26.77%
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) sum += num;

        // 和为奇数时，不可能划分成两个和相等的结合
        if (sum % 2 != 0) return false;

        int n = nums.length;

        sum = sum / 2;

        boolean [][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; ++i) dp[i][0] = true;

        // 开始状态转移
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，肯定不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    // 看看是否存在一种情况能够恰好装满
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    // Time: O(n * sum), Space: O(sum), Faster: 71.34%
    public boolean canPartition2(int[] nums) {

        int sum = 0;

        for (int num : nums) sum += num;

        // 和为奇数时，不可能划分成两个和相等的结合
        if (sum % 2 != 0) return false;

        int n = nums.length;

        sum = sum / 2;

        boolean [] dp = new boolean[sum + 1];

        dp[0] = true;

        // 开始状态转移
        for (int i = 0; i < n; ++i) {
            for (int j = sum; j >= 0; --j) {
                if (j - nums[i] >= 0)
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
