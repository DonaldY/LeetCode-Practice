package chapter2.topic2;

import java.util.Arrays;

/**
 * 268. Missing Number
 *
 * Input: [3,0,1]
 * Output: 2
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * 题意： 找到缺失的数
 *
 * 思路：
 * 1. 排序, 然后查找
 * 2. 两个数异或起来，就能查出 x^x = 0
 */
public class LeetCode_268 {

    public static void main(String[] args) {

        LeetCode_268 leetCode = new LeetCode_268();

        System.out.println(leetCode.missingNumber(new int[] {3, 0, 2}));
    }

    // 最坏Time:o(n^2) Space: o(1) faster: 13.95%
    public int missingNumber(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {

            if (i != nums[i]) return i;
        }

        if (nums[nums.length - 1] != nums.length) return nums.length;

        return -1;
    }

    // Time: o(n) Space: o(1) faster: 100%
    public int missingNumberWithBit(int[] nums) {

        int n = nums.length, result = n;

        for (int i = 0; i < n; ++i) result = result ^ i ^ nums[i];

        return result;
    }
}
