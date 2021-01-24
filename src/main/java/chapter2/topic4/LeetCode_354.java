package chapter2.topic4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author donald
 * @date 2021/01/25
 *
 * `LeetCode 354`. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 `(w, h)` 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * ```
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * ```
 *
 * 思路步骤：
 * 1. 先对宽度 `w` 进行升序排序，如果遇到 `w` 相同的情况，则按照高度 `h` 降序排序。
 * 2. 之后把所有的 `h` 作为一个数组，在这个数组上计算出的 `LIS` 的长度就是答案。
 */
public class LeetCode_354 {

    // Time: O(n * log(n)), Space: O(n), Faster: 87.03%
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        // 按照宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 对高度数组寻找 LIS
        int [] height = new int[n];
        for (int i = 0; i < n; ++i) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLISBinarySearch(height);
    }

    // Time: o(n * log(n)), Space: o(n), Faster:  92.62%
    private int lengthOfLISBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 牌堆数初始化为 0
        int len = 0;
        int [] top = new int[nums.length];
        for (int x : nums) {
            int left = binarySearchInsertPosition(top, len, x);
            // 把这张牌放到牌堆顶
            top[left] = x;
            // 没找到合适的牌堆，新建一堆
            if (left == len) ++len;
        }
        return len;
    }

    private int binarySearchInsertPosition(int[] d, int len, int x) {
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x < d[mid]) high = mid - 1;
            else if (x > d[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }
}
