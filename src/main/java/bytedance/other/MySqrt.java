package bytedance.other;

/**
 * 拓展练习 - x的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 题意: 求一个数的平方根, 取整数部分
 *
 * 思路:
 * 1. 1 ~ x/2, 找到一个比x小的数
 * 2. 二分查找
 * 3. 牛顿迭代法
 *
 * Tips: 相乘可能越界
 */
public class MySqrt {

    public static void main(String[] args) {

        MySqrt mySqrt = new MySqrt();

        System.out.println(mySqrt.mySqrt(2147483647));
    }

    // Time: o(n), Space: o(1)
    public int mySqrt(int x) {

        int result = 0;

        if (x == 1) return 1;

        for (long i = 1; i <= x / 2; ++i) {

            long num = i * i;

            if (num > x) return result;
            if (num == x) return (int) i;
            if (num < x) result = (int)i;
        }

        return result;
    }
}
