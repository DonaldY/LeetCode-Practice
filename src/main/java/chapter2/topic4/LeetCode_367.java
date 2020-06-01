package chapter2.topic4;

/**
 * @author donald
 * @date 2020/6/1
 *
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 *
 * 题意：
 * 求完全平方数，不能使用库里的 sqrt
 *
 * 思路：
 * 从 2 ～ n/2 二分查找
 */
public class LeetCode_367 {

    // Time: O(log(n)), Space: O(1), Faster: 100.00%
    public boolean isPerfectSquare(int num) {

        long head = 1, end = num;

        while (head <= end) {
            long mid = head + (end - head) / 2;
            long mid2 = mid * mid;
            if (mid2 == num) return true;
            else if (mid2 > num) end = mid - 1;
            else head = mid + 1;
        }
        return false;
    }
}
