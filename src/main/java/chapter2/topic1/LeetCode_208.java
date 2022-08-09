package chapter2.topic1;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * 题意： 实现前缀树
 *
 * 思路：
 * 1. 树的形式，拉链表
 *
 */
public class LeetCode_208 {

    // Faster: 70.53%
    class Trie {

        private class TrieNode {
            boolean endOfWord;    // 是否是一个单词结尾
            TrieNode [] children; // 指向 26个 子节点
            TrieNode() {
                this.endOfWord = false;
                this.children = new TrieNode[26];
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.endOfWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchEndNode(word);
            return node != null && node.endOfWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchEndNode(prefix);
            return node != null;
        }

        private TrieNode searchEndNode(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length() && cur != null; ++i) {
                int idx = str.charAt(i) - 'a';
                cur = cur.children[idx];
            }
            return cur;
        }
    }
}
