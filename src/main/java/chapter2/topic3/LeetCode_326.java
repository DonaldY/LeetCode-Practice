package chapter2.topic3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2021/03/16
 *
 * LeetCode 326. Power of Three
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * ```
 * Example 1:
 *
 * Input: n = 27
 * Output: true
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 *
 * Example 3:
 *
 * Input: n = 9
 * Output: true
 *
 * Example 4:
 *
 * Input: n = 45
 * Output: false
 * ```
 *
 * 题意：给你一个整数 n，你要写一个函数来判断它是否为 3 的幂。
 *
 * 思路：
 * 1. 循环除
 */
public class LeetCode_326 {

    // Faster: 99.98%
    public boolean isPowerOfThree(int n) {

        if (n <= 0) return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }

    private final int MAX_POWER = (int) (Math.log(Integer.MAX_VALUE) / Math.log(3));
    private final int MAX_NUM = (int) Math.pow(3, MAX_POWER);

    // Time: O(1), Space: O(1)
    public boolean isPowerOfThreeMath(int n) {
        return n > 0 && (MAX_NUM % n) == 0;
    }

    // 32 位整型变量可以表示的所有的 3 的幂
    private final Set<Integer> set = new HashSet<>(
            Arrays.asList(
                    1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
                    1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467
            )
    );

    // Time: O(1), Space: O(1)
    public boolean isPowerOfThreeHashSet(int n) {
        return set.contains(n);
    }
}
