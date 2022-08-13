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

    // 基数排序-二进制排序
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

    // 基数排序-十进制排序, Faster: 74.74%
    public int[] sortArrayRedixSort2(int[] nums) {
        // RadixSort 基数排序
        int n = nums.length;
        // 预处理，让所有的数都大于等于0
        for (int i = 0; i < n; ++i) {
            nums[i] += 50000; // 50000为最小可能的数组大小
        }
        // 找出最大的数字，并获得其最大位数
        int maxNum = nums[0];
        for (int value : nums) {
            if (value > maxNum) {
                maxNum = value;
            }
        }
        int num = maxNum, maxLen = 0;
        while (num > 0) {
            ++maxLen;
            num /= 10;
        }
        // 基数排序，低位优先
        int divisor = 1;
        int[] tmp = new int[n];
        for (int i = 0; i < maxLen; ++i) {
            radixSort(nums, tmp, divisor);
            swap(tmp, nums);
            divisor *= 10;
        }
        // 减去预处理量
        for (int i = 0; i < n; ++i) {
            nums[i] -= 50000;
        }
        return nums;
    }

    private void swap(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; ++i) {
            int temp = nums1[i];
            nums1[i] = nums2[i];
            nums2[i] = temp;
        }
    }

    private void radixSort(int[] nums, int[] tmp, int divisor) {
        int n = nums.length;
        int[] counts = new int[10];
        // 统计个、十、百、千、万上对应 0 ~ 9 的出现次数
        for (int num : nums) {
            int x = (num / divisor) % 10;
            ++counts[x];
        }
        // 前缀和
        for (int i = 1; i <= 9; ++i) {
            counts[i] += counts[i - 1];
        }
        // 从后向前赋值
        for (int i = n - 1; i >= 0; --i) {
            int x = (nums[i] / divisor) % 10;
            int index = counts[x] - 1;
            tmp[index] = nums[i];
            --counts[x];
        }
    }
}
