package chapter6.topic3;

/**
 * @author donald
 * @date 2022/10/20
 *
 * 思路：
 * 1. 计数， 然后赋值
 */
public class LeetCode_1122 {

    // Time: O(n), Space: O(n), Faster:
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = 1000;

        // 1. 计数
        int[] map = new int[n + 1];
        for (int num : arr1) ++map[num];

        int[] result = new int[arr1.length];
        int idx = 0;
        // 2. 按照 arr2 放置
        for (int i = 0; i < arr2.length; ++i) {
            while (map[i]-- > 0) {
                result[idx++] = i;
            }
        }

        // 3. 将剩余的放置
        for (int i = 0; i <= n; ++i) {
            while (map[i]-- > 0) {
                result[idx++] = i;
            }
        }

        return result;
    }
}
