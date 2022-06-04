package chapter2.topic2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 264. Ugly Number II
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * 题意： 找到第 n 个丑数
 *
 * Tips： 丑数的定义是质因数只包含 2，3，5 的正整数。另外，1 作为特例，也定义为丑数
 *
 * 思路：
 * 1. 最小堆，每一个丑数都从 2 3 5 这集合中找出
 * 2. DP
 */
public class LeetCode_264 {

    public int nthUglyNumber(int n) {
        return 0;
    }

    // Time: o(n * log(n)), Space: o(n), Faster: 5.19%
    public int getNthUglyNumberMinHeap(int n) {
        int uglyNum = -1;
        Queue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n > 0) {
            while (q.peek() == uglyNum) q.poll();
            uglyNum = q.poll();
            if (2L * uglyNum <= Integer.MAX_VALUE)
                q.add(2 * uglyNum);
            if (3L * uglyNum <= Integer.MAX_VALUE)
                q.add(3 * uglyNum);
            if (5L * uglyNum <= Integer.MAX_VALUE)
                q.add(5 * uglyNum);
            --n;
        }
        return uglyNum;
    }

    // Time: O(n), Space: O(n), Faster: 98.33%
    public int getNthUglyNumberDP(int n) {
        if (n <= 0) return -1;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int min = min(uglyNums[p2]*2, uglyNums[p3]*3, uglyNums[p5]*5);
            uglyNums[i] = min;
            if (min == uglyNums[p2]*2) ++p2;
            if (min == uglyNums[p3]*3) ++p3;
            if (min == uglyNums[p5]*5) ++p5;
        }
        return uglyNums[n-1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
