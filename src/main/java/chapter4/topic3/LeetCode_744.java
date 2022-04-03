package chapter4.topic3;

/**
 * @author donald
 * @date 2022/04/03
 */
public class LeetCode_744 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        char nextGreater = letters[0];
        for (int i = 0; i < length; i++) {
            if (letters[i] > target) {
                nextGreater = letters[i];
                break;
            }
        }
        return nextGreater;

    }
}
