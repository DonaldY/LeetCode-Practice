package chapter1.topic2;

/**
 * 53. Maximum Subarray
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 思路：
 * 1. 暴力求法，两层for循环
 * 2. 遍历一遍，负数 + 负数没有任何意义
 *    前面累加值为负数，则对后面没有正向的贡献， 所以可以直接舍弃前面这段子序列的和
 *
 */
public class LeetCode_53 {

    public static void main(String[] args) {

        LeetCode_53 leetCode = new LeetCode_53();

        // [-2,1,-3,4,-1,2,1,-5,4]
        System.out.println(leetCode.maxSumOfSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    // Time: O(n ^ 2), Space: O(1), Faster: 5.05%
    public int maxSumOfSubArray2(int [] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for(int j = i + 1; j < nums.length; ++j) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int test(int [] nums) {
        int max = Integer.MIN_VALUE;
        for (int cur = 0; cur < nums.length; ++cur) {

        }
        return 1;
    }

    // Time: O(n), Space: O(1), Faster: 95.05%
    public int maxSumOfSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }

        return max;
    }
}















