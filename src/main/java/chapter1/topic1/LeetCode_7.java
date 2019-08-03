package chapter1.topic1;

/**
 * 7. Reverse Integer
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * 题意： 反转整型
 *
 * 思路： 直接反转
 */
public class LeetCode_7 {

    public static void main(String[] args) {

        LeetCode_7 leetCode = new LeetCode_7();

        System.out.println(leetCode.reverse(1534236469));
    }

    public int reverse(int x) {

        long result = 0;

        int t = Math.abs(x);

        int isFirst = 0;

        int temp = 0;

        while ( t > 0) {

            temp = t % 10;

            t /= 10;

            if (isFirst == 0 && temp == 0) {

                continue;
            }

            if (result * 10 > 2147483647) {

                return 0;
            }

            result = result * 10;

            result += temp;

            isFirst = 1;
        }

        if (x < 0) {

            result = -result;
        }

        return (int) result;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
