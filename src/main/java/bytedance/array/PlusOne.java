package bytedance.array;

import java.util.LinkedList;

/**
 * @author donald
 * @date 2020/11/24
 *
 * Leetcode 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 思路：
 * 1. 从后往前遍历，进位则增
 *    队列
 * 2. 数学解法
 *    I. 进位是从后往前, 若进位, 则数为 0
 */
public class PlusOne {

    // Time : O(n), Space: O(n), Faster: 5.29%
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) return new int[0];

        int carry = 1;
        LinkedList<Integer> node = new LinkedList<>();
        int i = digits.length - 1;

        for (; i >= 0; --i) {

            int temp = digits[i] + carry;
            carry = temp > 9 ? 1 : 0;
            node.addFirst(temp % 10);
        }

        if (carry == 1) {

            node.addFirst(carry);
        }

        Integer[] tmp = node.toArray(new Integer[0]);

        int[] result = new int[node.size()];

        for (int j = 0; j < tmp.length ; ++j) {

            result[j] = tmp[j];
        }

        return result;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
