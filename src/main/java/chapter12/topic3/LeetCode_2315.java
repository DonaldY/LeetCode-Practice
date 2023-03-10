package chapter12.topic3;

/**
 * @author donald
 * @date 2023/01/29
 */
public class LeetCode_2315 {

    // Time: O(n), Space: O(1), Faster: 59.15%
    public int countAsterisks(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }
}
