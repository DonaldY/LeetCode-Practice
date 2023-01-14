package chapter12.topic2;

/**
 * @author donald
 * @date 2023/01/15
 */
public class LeetCode_2293 {

    // 模拟过程：
    // Time: O(logn), Space: O(1), Faster: 71.1%
    public int minMaxGame(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        while (nums.length != 1) {
            int n = nums.length / 2;
            int[] newNums = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }
}
