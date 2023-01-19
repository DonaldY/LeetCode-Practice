package chapter12.topic2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2023/01/19
 */
public class LeetCode_2299 {

    boolean isCapital = false, isLowerCase = false, isNumber = false, isSpecialValue = false;
    Set<Character> SET = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
    // Time: O(n), Space: O(n), Faster: 69.57%
    public boolean strongPasswordCheckerII(String password) {
        if (null == password || password.length() < 8) return false;
        executeChar(password.charAt(0));
        for (int i = 1; i < password.length(); ++i) {
            executeChar(password.charAt(i));
            if (password.charAt(i) == password.charAt(i - 1)) return false;
        }
        return isCapital && isLowerCase && isNumber && isSpecialValue;
    }

    private void executeChar(char c) {
        if (c <= 'z' && c >= 'a') {
            isLowerCase = true;
        } else if (c <= 'Z' && c >= 'A') {
            isCapital = true;
        } else if (c <= '9' && c >= '0') {
            isNumber = true;
        } else if (SET.contains(c)) {
            isSpecialValue =true;
        }
    }
}
