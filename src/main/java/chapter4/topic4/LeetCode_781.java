package chapter4.topic4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2021/04/04
 *
 * LeetCode 781. 森林中的兔子
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * ```
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * ```
 *
 * 题意： 至少有多少只兔子
 *
 * 思路 - 1：
 * 相同的答案可能是颜色相同的兔子，用 Map 维持计数。
 * 若相同答案的兔子超出数量，则重新计数。
 * 若相同颜色为0, 则直接加1.
 *
 * 统一计算： 用个 Map 保存相同数字的兔子
 *          若超过则重新计数
 *
 * 特殊案例： [0, 0, 1, 1, 1]  result : 6
 *
 *
 * 思路 - 2：
 * 如果有 x 只兔子都回答 y，则至少有 x / (y + 1) 向上取整; 且每种颜色有 y + 1 只兔子
 * 所以兔子数最少为 [x / (y + 1)] * (y + 1)
 */
public class LeetCode_781 {

    // Time: O(n), Space: O(n), Faster: 68.18%
    public int numRabbits1(int[] answers) {

        if (null == answers || answers.length == 0) return 0;

        Map<Integer, Integer> rabbitMap = new HashMap<>(answers.length);

        int result = 0;

        for (int rabbit : answers) {

            if (!rabbitMap.containsKey(rabbit)) {

                result += rabbit + 1;

                rabbitMap.put(rabbit, 0);

                continue;
            }

            int totalRabbits = rabbitMap.get(rabbit);

            if (totalRabbits == rabbit) {

                result += rabbit + 1;
                rabbitMap.put(rabbit, 0);

                continue;
            }

            rabbitMap.put(rabbit, totalRabbits + 1);
        }

        return result;
    }

    public int numRabbits2(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
