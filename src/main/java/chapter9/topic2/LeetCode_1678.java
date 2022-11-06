package chapter9.topic2;

/**
 * @author donald
 * @date 2022/11/06
 */
public class LeetCode_1678 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public String interpret(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == 'G') {
                sb.append('G'); i++;
            } else if (i + 1 < n && s.charAt(i + 1) == ')') {
                sb.append('o'); i += 2;
            } else {
                sb.append("al"); i += 4;
            }
        }
        return sb.toString();
    }
}
