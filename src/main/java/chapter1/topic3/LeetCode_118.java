package chapter1.topic3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 题意： 给一个行数，输出pascal三角
 *
 * 思路：
 * 观察特征，寻找联系
 * 1.
 */
public class LeetCode_118 {

    // Time: o(n^2), Space: o(n^2), Faster: 100.00%
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; ++i) {

            List<Integer> list = Arrays.asList(new Integer[i + 1]);
            list.set(0, 1); list.set(i, 1);

            for (int j = 1; j < i; ++j) {

                list.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }

            result.add(list);
        }

        return result;
    }
}
