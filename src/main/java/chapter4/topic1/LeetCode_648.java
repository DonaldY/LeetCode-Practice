package chapter4.topic1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author donald
 * @date 2022/10/19
 *
 * 思路：
 * 1. 暴力法： hash表存储，一个个比对 startWith
 * 2. 前缀树： 先构建前缀树，再一个个比较
 */
public class LeetCode_648 {
    // 方法一： hash表
    // Time: O(n*m*m), Space: O(n), Faster: 33.86%
    public String replaceWordsHash(List<String> dictionary, String sentence) {
        if (null == dictionary || dictionary.isEmpty()) return sentence;
        // 1. 创建hash表
        Set<String> words = new HashSet<>(dictionary);

        // 2. 比较对比字符串
        String[] strArr = sentence.split(" "); // 按空格拆分
        String[] result = new String[strArr.length]; // 存放结果
        for (int i = 0; i < strArr.length; ++i) {
            int minLen = Integer.MAX_VALUE;
            String str = strArr[i];
            for (String word : words) {
                if (strArr[i].startsWith(word)) {
                    if (word.length() < minLen) {
                        minLen = word.length();
                        str = word;
                    }
                }
            }
            result[i] = str;
        }

        // 3. 组装结果数组: 加回空格
        return String.join(" ", result);
    }

    private class TrieNode {
        boolean endOfWord;    // 是否是一个单词结尾
        TrieNode [] children; // 指向 26个 子节点
        TrieNode() {
            this.endOfWord = false;
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root = new TrieNode();

    // 方法二： 前缀树
    // Faster: 94.88%
    public String replaceWords(List<String> dictionary, String sentence) {
        if (null == dictionary || dictionary.isEmpty()) return sentence;

        // 1. 构建前缀树
        buildTrieTree(dictionary);

        // 2. 比较对比字符串
        String[] strArr = sentence.split(" "); // 按空格拆分
        String[] result = new String[strArr.length]; // 存放结果
        for (int i = 0; i < strArr.length; ++i) {
            String word = searchEndNode(strArr[i]);
            if (word.length() != 0) result[i] = word;
            else result[i] = strArr[i];
        }

        // 3. 组装结果数组: 加回空格
        return String.join(" ", result);
    }

    // 构建前缀树
    private void buildTrieTree(List<String> dictionary) {
        for (String dict : dictionary) {
            insert(dict);
        }
    }
    // 前缀树： 新增方法
    private void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
    }

    // 前缀树：搜索节点
    private String searchEndNode(String str) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() && cur != null; ++i) {
            int idx = str.charAt(i) - 'a';
            cur = cur.children[idx];
            if (null != cur) sb.append(str.charAt(i));
            if (null != cur && cur.endOfWord) break; // 用于发现最小词根
        }
        // 能找到完整词根
        if (null != cur && cur.endOfWord) return sb.toString();
        return "";
    }
}
