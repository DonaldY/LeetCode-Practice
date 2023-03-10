package chapter9.topic4;

import java.util.Arrays;

/**
 * @author donald
 * @date 2023/02/04
 */
public class LeetCode_1798 {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}
