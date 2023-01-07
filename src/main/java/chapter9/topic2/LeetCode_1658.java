package chapter9.topic2;


/**
 * @author donald
 * @date 2023/01/07
 */
public class LeetCode_1658 {

    public static void main(String[] args) {

        LeetCode_1658 leetCode_1658 = new LeetCode_1658();
        System.out.println(leetCode_1658.minOperations(new int[]{1,1,4,2,3}, 5));
    }

    // 暴力法：DFS，一个树
    // Time: O(), Space: O(), Faster:
    public int minOperations(int[] nums, int x) {
        if (null == nums) return -1;

        int n = nums.length;
        int ans = n + 1;

        int min1 = dfs(1, n - 1, nums, x - nums[0], 1);
        int min2 = dfs(0, n - 2, nums, x - nums[n - 1], 1);

        ans = Math.min(Math.min(ans, min1), min2);

        return ans == n + 1 ? -1 : ans;
    }

    private int dfs(int left, int right, int[] nums, int sum, int num) {

        if (0 == sum) return num;

        int n = nums.length;
        int ans = n + 1;
        if (left > right) return ans;
        if (sum < 0) return ans;


        int min1 = dfs(left + 1, right, nums, sum - nums[left], num + 1);
        int min2 = dfs(left, right - 1, nums, sum - nums[right], num + 1);

        ans = Math.min(Math.min(ans, min1), min2);

        return ans;
    }

    // 滑动窗口：双指针
    // Time: O(n), Space: O(1), Faster: 95.83%
    public int minOperationsMove(int[] nums, int x) {
        int sum = 0, n = nums.length, right = n;
        while (right > 0 && sum + nums[right - 1] <= x) // 计算最长后缀
            sum += nums[--right];
        if (right == 0 && sum < x) return -1; // 全部移除也无法满足要求
        int ans = sum == x ? n - right : n + 1;
        for (int left = 0; left < n; ++left) {
            sum += nums[left];
            while (right < n && sum > x) // 缩小后缀长度
                sum -= nums[right++];
            if (sum > x) break; // 缩小失败，说明前缀过长
            if (sum == x) ans = Math.min(ans, left + 1 + n - right); // 前缀+后缀长度
        }
        return ans > n ? -1 : ans;
    }
}
