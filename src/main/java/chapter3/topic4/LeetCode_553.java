package chapter3.topic4;

/**
 * @author donald
 * @date 2022/02/27
 *
 *
 * 题意： 求到最大值
 *
 * 思路：
 * 1. 数学方法
 */
public class LeetCode_553 {

    // Time: O(n), Space: O(1), Faster: 78.05%
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuffer res = new StringBuffer();
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i = 2; i < n; i++) {
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }
}
