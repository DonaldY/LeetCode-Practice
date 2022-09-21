package chapter5.topic2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author donald
 * @date 2022/09/21
 *
 * 854. 相似度为 K 的字符串
 *
 * 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
 *
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
 *
 * 示例 1：
 *
 * 输入：s1 = "ab", s2 = "ba"
 * 输出：1
 *
 *
 * 示例 2：
 *
 * 输入：s1 = "abc", s2 = "bca"
 * 输出：2
 *
 */
public class LeetCode_854 {

    // Faster: 85.06%
    int n;
    String t;
    int f(String s) {
        int ans = 0;
        for (int i = 0; i < n; i++) ans += s.charAt(i) != t.charAt(i) ? 1 : 0;
        return ans + 1 >> 1;
    }
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        t = s2;
        n = s1.length();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b)->{
            int v1 = f(a), v2 = f(b), d1 = map.get(a), d2 = map.get(b);
            return (v1 + d1) - (v2 + d2);
        });
        map.put(s1, 0);
        pq.add(s1);
        while (!pq.isEmpty()) {
            String poll = pq.poll();
            int step = map.get(poll);
            char[] cs = poll.toCharArray();
            int idx = 0;
            while (idx < n && cs[idx] == t.charAt(idx)) idx++;
            for (int i = idx + 1; i < n; i++) {
                if (cs[i] != t.charAt(idx) || cs[i] == t.charAt(i)) continue;
                swap(cs, idx, i);
                String nstr = String.valueOf(cs);
                swap(cs, idx, i);
                if (map.containsKey(nstr) && map.get(nstr) <= step + 1) continue;
                if (nstr.equals(t)) return step + 1;
                map.put(nstr, step + 1);
                pq.add(nstr);
            }
        }
        return -1; // never
    }
    void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}
