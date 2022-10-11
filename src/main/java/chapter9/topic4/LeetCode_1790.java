package chapter9.topic4;

/**
 * @author donald
 * @date 2022/10/11
 *
 * 思路： 哈希表判断是否包含相等字符
 */
public class LeetCode_1790 {

    // Time: O(), Space: O(), Faster: 42.50%
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] map = new int[26];
        for (char c : s1.toCharArray()) ++map[c - 'a'];
        int cnt = s1.length();
        for (char c: s2.toCharArray()) {
            if (map[c - 'a'] > 0) {
                --cnt;
                --map[c - 'a'];
            }
        }
        if (cnt != 0) return false;

        int flag = 2;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (s1.charAt(i) != s2.charAt(i) && flag > 0) {
                --flag;
            } else {
                return false;
            }
        }
        return true;
    }
}
