package chapter2.topic4;

/**
 * @author donald
 * @date 2022/01/02
 *
 * 390. 消除游戏
 *
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 *
 * 示例：
 *
 * 输入:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * 输出:
 * 6
 *
 * 题意： 求最后一个元素
 *
 * 思路：
 * 1. 常规方法： 循环删除
 * 2. 约瑟夫环：
 *    假如输入为 n，我们使用 f(n) 表示 从左到右(forward) 的最终结果，使用 b(n)表示 从右到左(backward) 的最终结果。则：
 *    - 当 n = 1 时，存在 f(n) = 1, b(n) = 1
 *    - 对于任意 n，存在 f(n) + b(n) = n + 1
 *    - 对于 n > 2 的情况下，f(n) = 2 * b(n / 2)
 *    所以：f(n) = 2 * (n / 2 + 1 - f(n / 2))
 */
public class LeetCode_390 {

    // 常规方法：
    // Time: O(n), Space: O(1), Faster: 85.24%
    public int lastRemaining0(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }


    // 约瑟夫环：
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
