package chapter5.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2022/04/17
 *
 * 819. 最常见的单词
 *
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * 示例：
 *
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *
 * 题意： 找出现最多的词
 *
 * 思路： 辅助 Hash 表
 */
public class LeetCode_819 {

    Set<Character> set = new HashSet<>(Arrays.asList('!', '?', '\'', ',', ';', '.'));

    // Faster: 33.29%
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> table = new HashSet<>(banned.length);
        Collections.addAll(table, banned);

        Map<String, Integer> map = getMap(paragraph, table);

        int max = 0; String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (max < entry.getValue()) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }

    private Map<String, Integer> getMap(String paragraph, Set<String> table) {

        char[] arr = paragraph.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            if (set.contains(arr[i])) arr[i] = ' ';
        }

        paragraph = new String(arr);

        Map<String, Integer> map = new HashMap<>();

        List<String> paraList = Arrays.asList(paragraph.split("\\s+"));

        for (String str : paraList) {

            String real = str.toLowerCase();
            if (!table.contains(real)) {
                map.put(real, map.getOrDefault(real, 0) + 1);
            }
        }

        return map;
    }
}
