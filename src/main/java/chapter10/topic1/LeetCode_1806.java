package chapter10.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2023/01/09
 */
public class LeetCode_1806 {

    // 暴力法：直接模拟
    // Time: O(n ^ 2), Space: O(n), Faster: 65.79%
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int step = 0;
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    arr[i] = perm[i / 2];
                }
            }
            perm = arr;
            step++;
            if (Arrays.equals(perm, target)) {
                break;
            }
        }
        return step;
    }
}
