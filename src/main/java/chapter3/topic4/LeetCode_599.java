package chapter3.topic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author donald
 * @date 2022/03/14
 *
 * 599. 两个列表的最小索引总和
 *
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *  
 * 题意： 找索引最小值
 *
 * 思路： 利用辅助 map
 * 1. 遍历数组1, 放入 hashmap 记录下标
 * 2. 遍历数组2, 是否存在，存在则对比下标
 */
public class LeetCode_599 {

    // Time: O(n), Space: O(n), Faster: 87.25%
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> result = new ArrayList<>(list1.length);
        Map<String, Integer> map = new HashMap<>(list1.length);

        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int index = i + map.get(list2[i]);
                if (index > min) continue;
                if (index < min) {
                   result.clear();
                   min = index;
                }
                result.add(list2[i]);
            }
        }

        String [] arr = new String[result.size()];

        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
