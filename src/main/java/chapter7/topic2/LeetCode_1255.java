package chapter7.topic2;

/**
 * @author donald
 * @date 2023/02/26
 */
public class LeetCode_1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length, res = 0;
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        for (int s = 1; s < (1 << n); s++) {
            int[] wordCount = new int[26]; // 统计子集 s 所有单词的字母数目
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) { // words[k] 不在子集 s 中
                    continue;
                }
                for (int i = 0; i < words[k].length(); i++) {
                    char c = words[k].charAt(i);
                    wordCount[c - 'a']++;
                }
            }
            boolean ok = true; // 判断子集 s 是否合法
            int sum = 0; // 保存子集 s 的得分
            for (int i = 0; i < 26; i++) {
                sum += score[i] * wordCount[i];
                ok = ok && (wordCount[i] <= count[i]);
            }
            if (ok) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
