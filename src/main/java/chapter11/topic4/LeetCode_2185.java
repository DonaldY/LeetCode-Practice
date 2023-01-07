package chapter11.topic4;

/**
 * @author donald
 * @date 2023/01/08
 */
public class LeetCode_2185 {

    // 暴力法：
    // Time: O(n*m), Space: O(1), Faster: 100%
    public int prefixCount(String[] words, String pref) {
        if (null == words || words.length == 0) return 0;
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) ++ans;
        }
        return ans;
    }
}
