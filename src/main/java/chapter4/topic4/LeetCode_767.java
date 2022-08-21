package chapter4.topic4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/08/21
 *
 * 字符串重组
 *
 * 这个题目说的是，给你一个只包含小写字母的字符串 S，你要判断是否可以通过重新组织字符串中的字符，使得任意两个相邻的字符都不相同。
 * 如果可以，则返回其中一种可能的重组结果；如果不可以，则返回空字符串。
 *
 * 比如说，给你的字符串是：
 *
 * S = "aab"
 *
 * 你可以将它重新组织成 aba，这样相邻的字符就都不相同，因此返回 aba 即可。
 *
 * 再比如说，给你的字符串是：
 *
 * S = "aaab"
 *
 * 对于这个字符串，无论你怎么重新排列，都无法使得所有相邻的字符不相同。因此你要返回空字符串。
 *
 * 思路： 由于相同字符之间至少间隔一个位置，因此在重新排列字符时，我们只要以两个位置为一组，然后重复这个填充过程即可。
 * 1. 优先队列
 */
public class LeetCode_767 {

    // Time: O(n), Space: O(n), Faster: 28.73%
    public String reorganizeStringMaxHeap(String S) {
        if (S == null || S.length() == 0) return "";
        // 1. 求数量
        int[] freqs = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            ++freqs[S.charAt(i) - 'a'];
        }
        // 2. 优先队列： 排序， 字典序小的靠前：避免冲突
        Queue<int[]> q = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]
        );
        for (int i = 0; i < freqs.length; ++i) {
            if (freqs[i] != 0) q.add(new int[]{'a'+i, freqs[i]});
        }

        // 3. 每次取两个字母来拼接
        StringBuilder sb = new StringBuilder();
        while (q.size() > 1) {
            int[] first = q.poll(), second = q.poll();
            sb.append((char)first[0]).append((char)second[0]);
            if (--first[1] > 0) q.add(first);
            if (--second[1] > 0) q.add(second);
        }
        if (q.isEmpty()) return sb.toString();
        int[] peek = q.poll();
        if (peek[1] != 1) return "";
        return sb.append((char)peek[0]).toString();
    }
}
