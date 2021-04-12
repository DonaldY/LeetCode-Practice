package chapter1.topic4;

import java.util.Arrays;

/**
 * @author donald
 * @date 2021/04/12
 *
 * LeetCode 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * ```
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 *
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 * ```
 *
 * 题意： 数组拼接成最大的数
 *
 *
 * 思路：
 * 1. 排序（按照首位大小）, 34 > 30, 30 < 3, 34 > 3
 */
public class LeetCode_179 {

    // Time: O(n ^ 2), Space: O(1), Faster:
    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) return "0";

        for (int i = 0; i < nums.length; ++i) {

            for (int j = i + 1; j < nums.length; ++j) {

                int s = nums[i];
                int p = nums[j];
                if (isCompare(s, p)) {
                    nums[i] = p;
                    nums[j] = s;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int num : nums) {

            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(isCompare(3, 34));
    }

    private static boolean isCompare(int s, int p) {

        char[] ss = String.valueOf(s).toCharArray();
        char[] pp = String.valueOf(p).toCharArray();

        int len = Math.min(ss.length, pp.length);

        char[] sss = new char[len + 1];
        char[] ppp = new char[len + 1];

        for (int i = 0; i < len ; ++i) {

            sss[i] = ss[i];
            ppp[i] = pp[i];
        }

        if (ss.length == len) sss[len] = ss[len - 1];
        if (pp.length == len) ppp[len] = pp[len - 1];

        for (int i = 0; i < len + 1; ++i) {

            if (sss[i] > ppp[i]) {

                return false;
            } else if (sss[i] < ppp[i]) {

                return true;
            }
        }

        return false;
    }

    // Time: O(nlogn * nlogn), Space: O(1), Faster: 99.50%
    public String largestNumber2(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
