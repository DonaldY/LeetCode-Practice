package chapter4.topic2;

/**
 * @author donald
 * @date 2022/10/19
 *
 * 思路： 回溯 + 前缀树
 */
public class LeetCode_676 {

    class MagicDictionary {

        private class TrieNode {
            boolean endOfWord;    // 是否是一个单词结尾
            TrieNode [] children; // 指向 26个 子节点
            TrieNode() {
                this.endOfWord = false;
                this.children = new TrieNode[26];
            }
        }
        private TrieNode root;

        public MagicDictionary() {
            this.root = new TrieNode();
        }

        // 前缀树：新增
        private void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.endOfWord = true;
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                insert(word);
            }
        }

        // 2. 前缀法, Faster: 76.15%
        public boolean search(String searchWord) {
            return searchInner(searchWord, root, 0, false);
        }

        private boolean searchInner(String searchWord, TrieNode node, int pos, boolean modified) {
            // 1. 递归出口：到根节点了
            if (pos == searchWord.length()) {
                return modified && node.endOfWord; // 如果修改过，则为 true
            }
            int idx = searchWord.charAt(pos) - 'a';
            // 2. 有子节点
            if (node.children[idx] != null) {
                // 向下查询
                if (searchInner(searchWord, node.children[idx], pos + 1, modified)) {
                    return true;
                }
            }
            // 3. 重要：
            //    1. 没查询到
            //    2. 完全匹配了： 用例 ["hello", "hallo"], 查询 "hello", 应该返回 true
            if (!modified) {
                for (int i = 0; i < 26; ++i) {
                    if (i != idx && node.children[i] != null) {
                        if (searchInner(searchWord, node.children[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
