package chapter10.topic1;

/**
 * @author donald
 * @date 2022/12/11
 */
public class LeetCode_1827 {
    // Time: O(n), Space: O(1), Faster:
    public int minOperations(int[] nums) {
        int pre = nums[0] - 1, res = 0;
        for (int num : nums) {
            pre = Math.max(pre + 1, num);
            res += pre - num;
        }
        return res;
    }
}
