package chapter6.topic1;

/**
 * @author donald
 * @date 2023/4/7
 */
public class LeetCode_1017 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int[] bits = new int[32];
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 1) != 0) {
                bits[i]++;
                if ((i & 1) != 0) {
                    bits[i + 1]++;
                }
            }
            n >>= 1;
        }
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int val = carry + bits[i];
            bits[i] = val & 1;
            carry = (val - bits[i]) / (-2);
        }
        int pos = 31;
        StringBuilder res = new StringBuilder();
        while (pos >= 0 && bits[pos] == 0) {
            pos--;
        }
        while (pos >= 0) {
            res.append(bits[pos]);
            pos--;
        }
        return res.toString();
    }
}
