package chapter2.topic2;

/**
 * @author donald
 * @date 2022/08/06
 *
 * 这个题目说的是，给你一个整数 n，1 ~ n 表示一个产品的 n 个版本。其中，从某个版本开始，产品发生了错误。导致从那个版本开始，后面所有版本的产品都有问题。
 *
 * 现在给你一个函数 isBadVersion，输入一个版本号，它会告诉你这个版本的产品是否有问题。你要利用这个函数，找到第一个出错的版本。
 *
 * 比如说，给你的 n 等于 6，也就是说你要在 1 ~ 6 这 6 个版本中，找到第一个出错的版本。
 *
 * 假设第一个出错的版本为 4，那么调用 isBadVersion 会得到：
 *
 * isBadVersion(1) => false
 * isBadVersion(2) => false
 * isBadVersion(3) => false
 * isBadVersion(4) => true
 * isBadVersion(5) => true
 * isBadVersion(6) => true
 *
 * 因此，对于这个例子，你要返回的第一个出错版本就是版本 4。
 *
 * 思路：二分搜索
 */
public class LeetCode_278 {
    // Time: O(log(n)), Space: O(1), Faster: 34.00%
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 题目中的框架提供
    private boolean isBadVersion(int num) {
        return false;
    }
}
