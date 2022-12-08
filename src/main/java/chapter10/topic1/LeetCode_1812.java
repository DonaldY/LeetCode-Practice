package chapter10.topic1;

/**
 * @author donald
 * @date 2022/12/08
 */
public class LeetCode_1812 {
    // Time: O(1), Space: O(1)
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;
    }
}
