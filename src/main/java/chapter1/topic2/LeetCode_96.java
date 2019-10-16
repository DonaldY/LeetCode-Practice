package chapter1.topic2;

/**
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 题意： 给一个数， 1 ～ n， 有多少个平衡二叉数（节点的左边都小于它，节点的右边都大于它）
 *
 * 思路：
 * 1. 1, 2, 3   3个数 d(0) * d(2) + d(1) * d(1) + d(2) * d(0)
 * 2. 卡特兰数
 */
public class LeetCode_96 {

    // Time: O(n ^ 2), Space: O(n), Faster: 100.00%
    public int numTrees(int n) {
        if (n < 0) return 0;
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= i; ++j)
                d[i] += d[j - 1] * d[i - j];

        return d[n];
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int numTreesMath(int n) {
        if (n < 0) return 0;
        long result = 1;
        for (int k = 1; k <= n; ++k)
            result = result * (n + k) / k;
        return (int)(result / (n + 1));
    }
}
