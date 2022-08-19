package chapter1.topic3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 帕斯卡三角形的第 K 行
 *
 * 这个题目说的是，给你一个非负整数 k，你要返回帕斯卡三角形的第 k 行。其中，k 从 0 开始算起。
 *
 * 帕斯卡三角形又称为杨辉三角形，它的特点是左右两条边上的数字都为 1，其它位置的数字等于左上方与右上方的两个数字之和。
 *
 * 以下是帕斯卡三角形的前 5 行：
 *
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 *  ...
 *
 * 比如说 k = 0，你要返回：
 *
 * [1]
 *
 * 再比如说 k = 3，你要返回：
 *
 * [1, 3, 3, 1]
 */
public class LeetCode_119 {

    // Faster: 100.00%
    public List<Integer> getRow(int rowIndex) {
        if (0 == rowIndex) return Collections.singletonList(1);
        if (1 == rowIndex) return Arrays.asList(1, 1);
        int[] pre = new int[] {1, 1};
        for (int i = 2; i <= rowIndex; ++i) {
            int[] temp = new int[i + 1];

            temp[0] = 1;
            temp[i] = 1;
            for (int j = 1; j < i; ++j) {
                temp[j] = pre[j] + pre[j - 1];
            }

            pre = temp;
        }
        List<Integer> result = new ArrayList<>(pre.length);
        for (int num : pre) result.add(num);
        return result;
    }
}
