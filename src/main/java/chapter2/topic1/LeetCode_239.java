package chapter2.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * 239. Sliding Window Maximum
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 题意：
 * 求出滑动窗口中最大值
 *
 * 规律：
 * 1. 窗口每次向右移动一次
 * 2. 第一个数字和最后一个数字，只被用到一次
 * 3. 第二个数字被用到2次，中间数字被用到三次
 *
 * 思路：
 * 1. 暴力破解
 */
public class LeetCode_239 {

    // Time: o(n * k), Space: o(n), Faster: 15.55%
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) return new int[0];

        List<Integer> temp = new ArrayList<>(nums.length);

        for (int i = 0; i + k <= nums.length; ++i) {

            int max = nums[i];

            for (int j = i; j < i + k; ++j) {

                if (nums[j] > max) {
                    max = nums[j];
                }
            }

            temp.add(max);
        }

        int [] result = new int[temp.size()];

        for (int i = 0; i < temp.size(); ++i) {

            result[i] = temp.get(i);
        }

        return result;
    }

}
