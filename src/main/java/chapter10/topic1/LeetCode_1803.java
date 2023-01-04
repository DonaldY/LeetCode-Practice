package chapter10.topic1;

/**
 * @author donald
 * @date 2023/01/05
 */
public class LeetCode_1803 {

    // 思路一：暴力法，直接对比
    // Time: O(n^2), Space: O(1), Faster: 超时
    public int countPairs(int[] nums, int low, int high) {
        if (null == nums || nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int result = nums[i] ^ nums[j];
                if (result <= high && result >= low) ++ans;
            }
        }
        return ans;
    }
}
