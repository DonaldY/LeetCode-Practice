package chapter2.topic4;

/**
 * @author donald
 * @date 2021/02/15
 *
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 *
 *
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 *
 *
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 *
 *
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 * 题意： 取模
 *
 * 难点：
 * 1. 如何处理用数组表示的指数？
 * 2. 如何得到求模之后的结果？
 * 3. 如何高效进行幂运算？
 *
 * 思路：
 *
 */
public class LeetCode_372 {

    // Faster: 72.00%
    public int superPow(int a, int[] b) {

        return superPowInner(a, b, b.length - 1);
    }

    private int superPowInner(int a, int[] b, int i) {

        if (i == -1) return 1;
        int last = b[i];
        --i;

        int part1 = myPow(a, last);
        int part2 = myPow(superPowInner(a, b, i), 10);

        // 每次乘法都要求模
        return (part1 * part2) % base;
    }

    int base = 1337;

    private int myPow(int a, int k) {

        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {

            // k 是奇数
            return (a * myPow(a, k - 1)) % base;
        } else {

            // k 是偶数
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
