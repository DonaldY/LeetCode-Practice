package bytedance.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组与排序 - 第k个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 题意: 第k个排列数, 从 1 开始
 *
 * 思路:
 * (从小到大排序)
 * 1. 把所有可能列举出来, 然后在查找
 * 2. 一遍查, 一遍找
 * 3. 先求出是哪一个数字开头, 然后逐个查找
 */
public class Permutation {

    public String getPermutation(int n, int k) {

        // validate n! > k
        if (factorial(n) > k) return "";

        if (n == 1) return "1";

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; ++i) list.add(i);

        StringBuilder stringBuilder = new StringBuilder();

        int leaf = n, num = k - 1;

        while (leaf > 0) {

            int fact = factorial(leaf - 1);

            int index = num / fact;

            stringBuilder.append(list.get(index));
            list.remove(index);

            num = num % fact;

            --leaf;
        }

        return stringBuilder.toString();
    }

    private int factorial(int n) {

        int num = 1;

        for (int i = 1; i <= n; ++i) num *= i;

        return num;
    }
}
