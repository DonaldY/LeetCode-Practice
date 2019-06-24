package chapter1.topic2;

/**
 * 72. Edit Distance
 *
 * You have the following 3 operations permitted on a word:
 *
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * 题意：最小编辑距离，给两个字符串，将字符串1转换为字符串2，需要几步
 *
 * 思路：
 * 1. 找到最大匹配字符串，然后进行添加操作
 * 2. 动态规划
 *
 *     ''  b   a
 * ''  0   1   2
 * c   1   1   2
 * a   2   2   1
 *
 * d(i, 0) = i
 * d(0, i) = i
 *
 * d(2, 2) = d(1, 1)
 * s(i-1) == t(j-1) => d(i,j)=d(i-1, j-1)
 *
 * d(2, 1) = min(d(1, 0), d(2,0), d(1,1)) + 1
 *
 * s(i-1)!=t(j-1) => d(i,j) = min(d(1, 0), d(2,0), d(1,1)) + 1
 *
 * return d(m-1, n-1)
 */
public class LeetCode_72 {

    public int minDistance(String word1, String word2) {

        return editDistance(word1, word2);
    }

    // Time: o(m * n), Space: o(m * n), Faster: 36.73%
    public int editDistance(String s, String t) {
        if (s == null || t == null) return 0;

        int m = s.length() + 1, n = t.length() + 1;
        int [][] d = new int[m][n];

        for (int i = 0; i < m; ++i)
            d[i][0] = i;
        for (int j = 0; j < n; ++j)
            d[0][j] = j;

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = Math.min(Math.min(d[i-1][j-1], d[i][j-1]), d[i-1][j]) + 1;
                }
            }
        }

        return d[m-1][n-1];
    }
}
