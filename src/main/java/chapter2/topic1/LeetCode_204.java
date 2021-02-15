package chapter2.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2021/02/15
 *
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 * ```
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 *
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 * ```
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 题目：找总共的质数（除1和本身，不能被其他数整除）
 *
 * 思路：
 * 1. 暴力法： 每个数计算，除 (1~ 根号本身数)
 * 2. 筛数法： 2 是一个素数，那么所有 2 的倍数
 * 3.
 */
public class LeetCode_204 {

    // 超出时间限制
    public int countPrimes(int n) {

        int cnt = 0;

        for (int i = 2; i < n; ++i) {

            if (isPrime(i)) ++cnt;
        }

        return cnt;
    }

    private boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); ++i) {

            // 有其他整除因子
            if (number % i == 0) return false;
        }

        return true;
    }

    // 超出时间限制
    public int countPrimes2(int n) {

        boolean [] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; ++i) {

            if (isPrime[i]) {

                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n ; ++i) {

            if (isPrime[i]) ++cnt;
        }

        return cnt;
    }

    // Time: O(NloglogN), Space: O(N), Faster: 88.01%
    public int countPrimes3(int n) {

        boolean [] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; ++i) {

            if (isPrime[i]) {

                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n ; ++i) {

            if (isPrime[i]) ++cnt;
        }

        return cnt;
    }
}
