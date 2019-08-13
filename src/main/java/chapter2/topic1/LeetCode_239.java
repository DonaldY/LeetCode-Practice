package chapter2.topic1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
 * 4. 结果长度 n - k + 1
 *
 * 思路：
 * 1. 暴力破解
 * 2. 红黑数（默认 升序）
 * 3. 最大堆（因为有删除，所以时间复杂度为暴力破解）
 * 4. 维护两个数组 0 4 2 1 0 8 2
 *    先分组，然后求这个组的首个和结尾的值
 *    一个从左到右 0 4 4 1 1 8 2
 *    一个从右到左 4 4 2 8 8 8 2
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

    // Time: O(k*n), Space: O(1), Faster: 15.55%
    public int[] maxNumInSlidingWindowBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int left = 0; left <= n-k; ++left) {
            int max = nums[left];
            for (int i = left; i < left+k; ++i) {
                max = Math.max(max, nums[i]);
            }
            result[left] = max;
        }
        return result;
    }

    // Time: O(n*log(k)), Space: O(k), Faster: 26.48%
    public int[] maxNumInSlidingWindowTreeMap(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length, p = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; ++i) map.put(nums[i], i);
        int[] result = new int[n - k + 1];
        result[p++] = map.lastKey();
        for (int i = k; i < n; ++i) {
            if (map.get(nums[i-k]) == i-k) map.remove(nums[i-k]);
            map.put(nums[i], i);
            result[p++] = map.lastKey();
        }
        return result;
    }

    // Time: O(n), Space: O(n), Faster: 94.50%
    public int[] maxNumInSlidingWindowOn(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];
        maxFromLeft[0] = nums[0];
        maxFromRight[n-1] = nums[n-1];
        for (int i = 1, j = n-2; i < n; ++i, --j) {
            maxFromLeft[i] = i % k == 0 ? nums[i] : Math.max(maxFromLeft[i-1], nums[i]);
            maxFromRight[j] = j % k == k-1 ? nums[j] : Math.max(maxFromRight[j+1], nums[j]);
        }
        for (int i = 0; i <= n-k; ++i) {
            result[i] = Math.max(maxFromRight[i], maxFromLeft[i+k-1]);
        }
        return result;
    }
}
