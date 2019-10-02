package chapter2.topic3;

/**
 * 338. Counting Bits
 *
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 * and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss?
 * Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * 题意： 统计[o, num]数中，每个数有多少 1
 *
 * 思路：
 * 1. 每一个求解 O(n * sizeof(integer))
 * 2. 每个在前一个基础上求解 O(n)
 *    1 1 0 0
 *    1 0 1 1
 *   &
 *    1 0 0 0
 */
public class LeetCode_338 {

    // Time: O(n * k), Space: O(1), Faster:
    public int[] countBits(int num) {

        if (num < 0) return new int[0];

        int [] result = new int[num + 1];

        for (int i = 1; i <= num; ++i) {

            result[i] = countNum(i);
        }

        return result;
    }

    private int countNum(int num) {

        int cnt = 0;

        while (num != 0) {

            num &= (num - 1);

            ++cnt;
        }

        return cnt;
    }

    // Time: O(n * k), Space: O(1), Faster:
    public int[] countBitsWith(int num) {

        if (num < 0) return new int[0];

        int [] result = new int[num + 1];

        for (int i = 1; i <= num; ++i) {

            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }
}
