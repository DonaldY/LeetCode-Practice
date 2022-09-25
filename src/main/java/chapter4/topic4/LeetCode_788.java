package chapter4.topic4;

/**
 * @author donald
 * @date 2022/09/25
 *
 * 旋转数字
 *
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *  
 * 示例：
 *
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 *
 * 思路：
 * 1. 暴力法： 每个数字遍历过去
 *    必须包含者其一： 2, 5, 6, 9
 *    可以包含： 0, 1, 8
 *    不能包含 3, 4, 7
 */
public class LeetCode_788 {

    // 方法一： 暴力法
    // Time: O(n ^ 2), Space: O(1), Faster: 77.69%
    public int rotatedDigits(int n) {
        if (n <= 0) return 0;
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (isValid(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean isValid(int num) {

        boolean flag = true; // 判断是否只包含： 0, 1, 8
        while (num != 0) {
            int tmp = num % 10;
            if (tmp == 3 || tmp == 4 || tmp == 7) return false;
            if (tmp == 2 || tmp == 5 || tmp == 6 || tmp == 9) flag = false;
            num /= 10;
        }

        return !flag;
    }
}
