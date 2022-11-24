package chapter4.topic4;

/**
 * @author donald
 * @date 2022/11/24
 */
public class LeetCode_795 {
    // Time: O(n), Space: O(1), Faster: 90.6%
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = -1, k = -1; i < n; i++) {
            if (nums[i] > right) {
                k = i;
            } else {
                if (nums[i] < left) {
                    if (j > k) ans += j - k;
                } else {
                    ans += i - k;
                    j = i;
                }
            }
        }
        return ans;
    }
}
