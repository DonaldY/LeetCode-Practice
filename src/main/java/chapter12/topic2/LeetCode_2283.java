package chapter12.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/01/11
 */
public class LeetCode_2283 {

    // 暴力法： HashMap
    // Time: O(n), Space: O(n), Faster: 100%
    public boolean digitCount(String num) {
        if (null == num || num.length() == 0) return true;
        int[] arr = new int[num.length() + 1];
        for (int i = 0; i < num.length(); ++i) {
            int idx = num.charAt(i) - '0';
            ++arr[idx];
        }
        for (int i = 0; i < num.length(); ++i) {
            int total = num.charAt(i) - '0';
            if (arr[i] != total) return false;
        }
        return true;
    }
}
