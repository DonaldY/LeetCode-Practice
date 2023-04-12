package chapter6.topic3;

/**
 * @author donald
 * @date 2023/04/12
 */
public class LeetCode_1147 {
    public int longestDecomposition(String text) {
        int n = text.length();
        int res = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                if (judge(text, l, r - len + 1, len)) {
                    res += 2;
                    break;
                }
                ++len;
            }
            if (l + len - 1 >= r - len + 1) {
                ++res;
            }
            l += len;
            r -= len;
        }
        return res;
    }

    public boolean judge(String text, int l1, int l2, int len) {
        while (len > 0) {
            if (text.charAt(l1) != text.charAt(l2)) {
                return false;
            }
            ++l1;
            ++l2;
            --len;
        }
        return true;
    }
}
