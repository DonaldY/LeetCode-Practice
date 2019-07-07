package chapter1.topic2;

/**
 * 69. Sqrt(x)
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * 题意：给一个数开根号，找到那个数的整数部分
 *
 * 思路：
 * 1. 直接调api，然后返回整数部分
 * 2. 从1开始查找，到x/2，找到平方后最接近x的数
 * 3. 用二分搜索来减少，查询范围
 */
public class LeetCode_69 {

    // Tine: o(1), Space: o(1), Faster: 100.00%
    public int mySqrt(int x) {

        return (int) Math.sqrt(x);
    }

    // Time:o (n), Space:o (1), Faster: Time Limit Exceeded
    public int mySqrtWithoutAPI(int x) {

        for (int i = 1; i < x; ++i) {

            int temp = i * i;

            if (temp == x) return i;

            if (temp > x) return  i - 1;
        }

        return 0;
    }

    // Time: o(log(n)), Space: o(1), Faster: 100.00%
    public int mySqrtWithBinarySearch(int x) {

        long low = 0, high = x;

        while (low <= high) {

            long mid = (low + high) / 2;

            long temp = mid * mid;

            if (temp == x) return (int)mid;
            else if (temp < x) low = mid + 1;
            else high = mid - 1;
        }

        return (int) high;
    }
}
