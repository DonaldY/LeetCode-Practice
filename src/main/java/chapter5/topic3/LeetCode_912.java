package chapter5.topic3;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/08/13
 *
 * 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 *
 */
public class LeetCode_912 {

    // Faster: 98.95%
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 计数排序
    // Time: O(n + k), Space: O(n + k), Faster: 99.97%
    public int[] sortArrayCounting(int[] nums) {
        // 1. 找最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 2. 定义计数数组并统计
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            ++counts[num - min]; // 落到数组上
        }
        // 3. 遍历输出结果
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < max - min + 1; ++i) {
            while (counts[i]-- > 0) {
                result[j++] = i + min;
            }
        }
        return result;
    }

    // 2 进制排序
    public int[] sortArrayRedixSort1(int[] nums) {
        sort(nums, 4, 0x0f);
        return nums;
    }

    // Time: O(32/b * n), Space: O(n + 2^b), Faster: 98.95%
    private void sort(int[] arr, int bits, int mask) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length, cnt = 32 / bits;
        int[] tmp = new int[n];
        int[] indexes = new int[1 << bits];
        for (int d = 0; d < cnt; ++d) {
            for (int num : arr) {
                int idx = (num >> (bits * d)) & mask;
                ++indexes[idx];
            }

            --indexes[0];
            for (int i = 1; i < indexes.length; ++i)
                indexes[i] = indexes[i] + indexes[i - 1];

            for (int i = n - 1; i >= 0; --i) {
                int idx = (arr[i] >> (bits * d)) & mask;
                tmp[indexes[idx]] = arr[i];
                --indexes[idx];
            }

            Arrays.fill(indexes, 0);
            int[] t = arr;
            arr = tmp;
            tmp = t;
        }
        // handle the negative number
        // get the length of positive part
        int len = 0;
        for (; len < n; ++len)
            if (arr[len] < 0) break;

        System.arraycopy(arr, len, tmp, 0, n - len); // copy negative part to tmp
        System.arraycopy(arr, 0, tmp, n - len, len); // copy positive part to tmp
        System.arraycopy(tmp, 0, arr, 0, n); // copy back to arr
    }
}
