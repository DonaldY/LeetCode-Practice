package chapter9.topic2;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/09/24
 *
 * 1652. 拆炸弹
 *
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 *
 * 示例 1：
 *
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * 思路： 滑动窗口， 双指针
 */
public class LeetCode_1652 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int[] decrypt(int[] code, int k) {
        if (null == code || code.length == 0) return new int[0];
        if (k == 0) return new int[code.length];
        // -(n - 1) <= k <= n - 1
        // [start, end)
        int start = k < 0 ? k + code.length : 1;
        int end = (start + Math.abs(k)) % code.length;
        int[] result = new int[code.length];
        int curSum = 0;
        for (int i = start; i != end; ) {
            curSum += code[i];
            i = (i + 1) % code.length;
        }
        result[0] = curSum;
        for (int i = 1; i < code.length; ++i) {
            curSum -= code[start];
            start = (start + 1) % code.length;
            curSum += code[end];
            end = (end + 1) % code.length;
            result[i] = curSum;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_1652 leetCode_1652 = new LeetCode_1652();
        int[] arr = new int[]{5,7,1,4};
        System.out.println(Arrays.toString(leetCode_1652.decrypt(arr, 3)));

        arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(leetCode_1652.decrypt(arr, 0)));

        arr = new int[]{2,4,9,3};
        System.out.println(Arrays.toString(leetCode_1652.decrypt(arr, -2)));
    }
}
