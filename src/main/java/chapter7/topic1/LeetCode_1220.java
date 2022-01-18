package chapter7.topic1;

/**
 * @author donald
 * @date 2022/01/18
 *
 * 1220. 统计元音字母序列的数目
 *
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 *
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 *
 * 示例 3：
 * 输入：n = 5
 * 输出：68
 */
public class LeetCode_1220 {

    public int countVowelPermutation2(int n) {
        int MOD = (int) 1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int j = 2; j <= n; j++) {
            long aa = e % MOD;
            long ee = (a + i) % MOD;
            long ii = (a + e + o + u) % MOD;
            long oo = (i + u) % MOD;
            long uu = a % MOD;
            a = aa; e = ee; i = ii; o = oo; u = uu;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }

    // Faster: 100%
    public int countVowelPermutation(int n) {
        long mod = 1_000_000_007;
        long[][] factor =
                {
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0}
                };

        long[][] res = fastPow(factor, n - 1, mod);
        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                ans = (ans + res[i][j]) % mod;
            }
        }
        return (int)ans;
    }

    public long[][] fastPow(long[][] matrix, int n, long mod) {
        int m = matrix.length;
        long[][] res = new long[m][m];
        long[][] curr = matrix;

        for (int i = 0; i < m; ++i) {
            res[i][i] = 1;
        }
        for (int i = n; i != 0; i >>= 1) {
            if ((i % 2) == 1) {
                res = multiply(curr, res, mod);
            }
            curr = multiply(curr, curr, mod);
        }
        return res;
    }

    public long[][] multiply(long[][] matrixA, long[][] matrixB, long mod) {
        int m = matrixA.length;
        int n = matrixB[0].length;
        long[][] res = new long[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = 0;
                for (int k = 0; k < matrixA[i].length; ++k) {
                    res[i][j] = (res[i][j] + matrixA[i][k] * matrixB[k][j]) % mod;
                }
            }
        }
        return res;
    }
}
