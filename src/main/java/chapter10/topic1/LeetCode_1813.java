package chapter10.topic1;

/**
 * @author donald
 * @date 2023/1/16
 */
public class LeetCode_1813 {

    // 暴力法：按空格分割
    // 前缀相同的词 + 后缀相同的词 == 最小字符串的长度
    // Time: O(n + m), Space: O(n + m), Faster: 99.12%
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        // 过滤前缀相同的词
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        // 过滤后缀相同的词
        while (j < words1.length - i && j < words2.length - i
                && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
