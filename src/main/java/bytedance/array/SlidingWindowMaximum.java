package bytedance.array;

/**
 * @author donald
 * @date 2020/11/26
 *
 * Leetcode 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  
 * 思路：
 * 1. 模拟个队列进出
 * 2. 红黑树
 * 3. 动态规划
 *    I. 从左到右遍历数组，建立数组 left。
 *   II. 从右到左遍历数组，建立数组 right。
 *  III. 建立输出数组 max(right[i], left[i + k - 1])，其中 i 取值范围为 (0, n - k + 1)。
 */
public class SlidingWindowMaximum {

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
