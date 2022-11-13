package chapter4.topic4;

/**
 * @author donald
 * @date 2022/11/13
 */
public class LeetCode_791 {

    public String customSortString(String order, String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) cnts[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnts[c - 'a']-- > 0) sb.append(c);
        }
        for (int i = 0; i < 26; i++) {
            while (cnts[i]-- > 0) sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }
}
