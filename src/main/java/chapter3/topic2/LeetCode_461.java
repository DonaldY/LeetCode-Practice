package chapter3.topic2;

/**
 * 461. Hamming Distance
 *
 *Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 题意： 汉明距离，找到两个数中对应不同bit的距离
 *
 * 思路：
 * 1. 先异或(相同则为0,不同则为1)， 找到1的个数
 *
 */
public class LeetCode_461 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public int hammingDistance(int x, int y) {

        int z = x ^ y;

        int cnt = 0;

        while (z !=0) {
            ++cnt;
            z &= (z - 1);
        }

        return cnt;
    }
}
