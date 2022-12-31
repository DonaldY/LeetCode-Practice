package chapter12.topic4;

/**
 * @author donald
 * @date 2023/1/1
 */
public class LeetCode_2351 {
    // 哈希表: 比对下
    // Time: O(n), Space: O(n), Faster: 100%
    public char repeatedCharacter(String s) {
        if (null == s || s.length() == 0) return 0;
        int [] arr = new int[26];
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] != 0) return c;
            ++arr[c - 'a'];
        }
        return 0;
    }
}
