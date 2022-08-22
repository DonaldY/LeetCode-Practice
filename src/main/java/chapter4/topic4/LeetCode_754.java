package chapter4.topic4;

/**
 * @author donald
 * @date 2022/08/22
 *
 * 到达终点需要的最少移动次数
 *
 * 这个题目说的是，给你一个整数，你要从数轴上的位置 0 移动到那个数字。在第 n 次移动中，你可以选择向左走 n 步，
 * 或者向右走 n 步。其中，n 从 1 开始。你要计算出，到达终点所需要的最少移动次数。
 *
 * 比如说，给你的数字是 3，你从位置 0 开始：
 *
 * 1. 第一次向右走 1 步（到达 1）
 * 2. 第二次向右走 2 步（到达 3）
 *
 * 因此，最少的移动次数是 2。
 *
 * 再比如说，给你的数字为 4，你从位置 0 开始：
 *
 * 1. 第一次向左走 1 步（到达 -1）
 * 2. 第二次向右走 2 步（到达 1）
 * 3. 第三次向右走 3 步（到达 4）
 *
 * 因此，最少的移动次数是 3。
 *
 *
 * 思路：
 * 1. 暴力法： DFS
 */
public class LeetCode_754 {

    // 方法一： 暴力法 DFS
    // Time: O(2^n), Space: O(1), Faster: 爆栈 target = -100000
    public int reachNumber(int target) {
        if (0 == target) return 0;

        return findNumber(0, target, 0);
    }

    private int findNumber(int start, int target, int cnt) {
        if (start == target) return cnt;
        if (cnt > Math.abs(target)) return Integer.MAX_VALUE;
        ++cnt;
        int left = findNumber(start - cnt, target, cnt);
        int right = findNumber(start + cnt, target, cnt);
        return Math.min(left, right);
    }
}