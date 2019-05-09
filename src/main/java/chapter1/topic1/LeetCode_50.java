package chapter1.topic1;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 *
 *
 */
public class LeetCode_50 {

    public static void main(String[] args) {

        LeetCode_50 leetCode = new LeetCode_50();
        System.out.println(leetCode.myPow(2, 10));
        System.out.println(leetCode.myPow(2.1, 3));
        System.out.println(leetCode.myPow(2, -2));
        System.out.println(leetCode.myPow(2, 0));
    }

    // Time: o(n) Space: o(1) faster:100%
    public double myPow(double x, int n) {

        return Math.pow(x, n);
    }
}
