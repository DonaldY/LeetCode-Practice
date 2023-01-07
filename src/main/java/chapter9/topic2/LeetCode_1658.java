package chapter9.topic2;

/**
 * @author donald
 * @date 2023/01/07
 */
public class LeetCode_1658 {

    // Time: O(), Space: O(), Faster:
    public int minOperations(int[] nums, int x) {
        if (null == nums) return -1;

        int ans = -1;
        int n = nums.length;

        int min1 = dfs(1, n - 1, nums, x - nums[0], 1);
        int min2 = dfs(0, n - 2, nums, x - nums[n - 1], 1);
        if (min1 != -1) {
            ans = min1;
        }
        if (min2 != -1) {
            if (ans == -1) return min2;
            else Math.min(min2, ans);
        }
        return ans;
    }

    private int dfs(int left, int right, int[] nums, int sum, int num) {
        if (left > right) return -1;
        if (0 == sum) return num;
        if (sum < 0) return -1;

        int ans = -1;
        int min1 = dfs(left + 1, right, nums, sum - nums[left], ++num);
        int min2 = dfs(left, right - 1, nums, sum - nums[right], ++num);
        if (min1 != -1) {
            ans = min1;
        }
        if (min2 != -1) {
            if (ans == -1) return min2;
            else Math.min(min2, ans);
        }
        return ans;
    }
}
