package chapter4.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/10/19
 *
 * 思路：
 * 1. 暴力法： 哈希表， 字符串一个个分割
 * 2. 前缀树：
 */
public class LeetCode_677 {

    public static void main(String[] args) {

        String str = "123";

        System.out.println(str.substring(0, 3));
    }

    // 方法一：暴力
    // Faster: 17.61%
    class MapSum {

        Map<String, Integer> map;
        public MapSum() {
            this.map = new HashMap<>();
        }

        // 新增： 直接新增设值
        public void insert(String key, int val) {
            this.map.put(key, val);
        }

        // 求数：有这个前缀的都累加上
        public int sum(String prefix) {
            int ans = 0;
            for (String str : map.keySet()) {
                if (str.startsWith(prefix)) {
                    ans += map.get(str);
                }
            }
            return ans;
        }
    }

    // 方法二： 前缀树 + 递归遍历子节点
    // Faster: 100.00%
    class MapSumTrie {

        public MapSumTrie() {
            this.root = new TrieNode();
        }

        // 前缀树：新增
        public void insert(String word, int val) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.value = val;
            cur.endOfWord = true;
        }

        public int sum(String prefix) {
            // 1. 先找到这个前缀的位置
            TrieNode node = searchEndNode(prefix);
            if (null == node) return 0;

            // 2. 遍历子树，求词根 value 和
            return dfs(node);
        }

        private int dfs(TrieNode node) {
            if (null == node) return 0;
            int sum = 0;
            if (node.endOfWord) sum += node.value;
            for (int i = 0; i < 26; ++i) {
                if (null != node.children[i]) sum += dfs(node.children[i]);
            }

            return sum;
        }

        // 搜索节点
        private TrieNode searchEndNode(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length() && cur != null; ++i) {
                int idx = str.charAt(i) - 'a';
                cur = cur.children[idx];
            }
            return cur;
        }

        private class TrieNode {
            boolean endOfWord;    // 是否是一个单词结尾
            TrieNode [] children; // 指向 26个 子节点
            int value;            // 对应值
            TrieNode() {
                this.endOfWord = false;
                this.children = new TrieNode[26];
                this.value = 0;
            }
        }
        private TrieNode root;
    }
}
