package chapter2.topic3;

/**
 * @author donald
 * @date 2022/01/10
 *
 * 306. 累加数
 *
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *
 * 示例 1：
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 示例 2：
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 *
 * 不会以0开头，但是没说0不行啊！
 *
 * 易错用例：
 *  - "101" true
 *  - "000" true
 *  - "0235813" false
 *
 * 枚举前两个数，前两个数，第三个数开始只有轱辘起来满足和才是true
 *
 * 题意：前两数相加
 *
 * 思路：dfs + 剪枝
 */
public class LeetCode_306 {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) {
            return false;
        }
        char[] nums = num.toCharArray();
        long num1 = 0;
        for (int i = 0; i < (len >> 1); i++) {
            num1 = num1 * 10 + nums[i] - '0';
            long num2 = 0;
            for (int j = i + 1; j < len - 1; j++) {
                if (j == i + 1 && nums[j] == '0') {
                    if (this.f(nums, j + 1, num1, num2)) {
                        return true;
                    }
                    break;
                }
                num2 = num2 * 10 + nums[j] - '0';
                if (this.f(nums, j + 1, num1, num2)) {
                    return true;
                }
            }
            if (num1 == 0) {// 第一个是0，i就试一轮
                break;
            }
        }
        return false;
    }

    private boolean f(char[] nums, int start, long num1, long num2) {
        if (nums[start] == '0') {
            if (num1 + num2 == nums[start] - '0') {// 000000
                if (start == nums.length - 1) {
                    return true;
                } else if (this.f(nums, start + 1, num2, nums[start])) {
                    return true;
                }
            }
            return false;
        }
        long num3 = 0;
        for (int i = start; i < nums.length; i++) {
            num3 = num3 * 10 + nums[i] - '0';
            if (num1 + num2 == num3) {
                if (i == nums.length - 1) {
                    return true;
                } else {
                    if (this.f(nums, i + 1, num2, num3)) {
                        return true;
                    }
                }
            } else if (num3 > num1 + num2) {
                return false;
            }
        }
        return false;
    }
}
