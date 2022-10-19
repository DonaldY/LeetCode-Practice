package chapter5.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2022/10/19
 *
 * 思路：
 * 1. 暴力法： 每一个比较， endWith
 * 2. 前缀树： 字符串倒序插入: 给 time, 在前缀树里是 emit
 */
public class LeetCode_820 {

    public static void main(String[] args) {

        LeetCode_820 leetCode_820 = new LeetCode_820();
        leetCode_820.minimumLengthEncodingTrie(new String[] {"time", "me", "bell"});
    }

    // 方法一： 暴力法，排序 + 对比
    // Time: O(n*m), Space: O(n), Faster: 5.05%
    public int minimumLengthEncoding(String[] words) {
        if (null == words || words.length == 0) return 0;

        // 1. 以长度大小 降序
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        // 2. 需要多少个字符串
        List<String> strList = new ArrayList<>(words.length);
        for (String str : words) {
            boolean flag = true;
            if (strList.isEmpty()) strList.add(str);
            for (String word : strList) {
                if (word.endsWith(str)) { // 是否有这个后缀
                    flag = false;
                    break;
                }
            }
            if (flag) {
                strList.add(str);
            }
        }

        // 3. 求字符串长度
        int len = 0;
        for (String str : strList) {
            len += str.length();
        }

        return len + strList.size(); // +上需要多少个 #
    }

    // 方法二： 前缀树 + 字符串倒序
    // Time: O(nlogn), Sapce: O(n), Faster: 61.38%
    public int minimumLengthEncodingTrie(String[] words) {
        if (null == words || words.length == 0) return 0;
        root = new TrieNode();

        // 1. 记录前缀树根节点 与 下标(在 words 中的下标)
        Map<TrieNode, Integer> map = new HashMap<>();

        // 2. 构建前缀树
        for (int i = 0; i < words.length; ++i) {
            TrieNode node = insert(words[i]);
            map.put(node, i);
        }

        // 3. 求字符串列表总字符数
        int len = 0;
        for (Map.Entry<TrieNode, Integer> entry : map.entrySet()) {
            if (0 == entry.getKey().childCnt) {
                len += words[entry.getValue()].length() + 1;
            }
        }

        return len;
    }

    // 新增
    private TrieNode insert(String word) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; --i) { // 字符串倒序插入
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
                cur.childCnt += 1;
            }
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
        return cur;
    }

    private class TrieNode {
        boolean endOfWord;    // 是否是一个单词结尾
        TrieNode [] children; // 指向 26个 子节点
        int childCnt;         // 子节点个数
        TrieNode() {
            this.endOfWord = false;
            this.children = new TrieNode[26];
            this.childCnt = 0;
        }
    }
    private TrieNode root;
}
