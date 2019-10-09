package chapter3.topic2;

/**
 * 493. Reverse Pairs
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 *
 * 题意： 找到符合要求的逆序对数
 *
 * Tips： 关于数值需要注意数值的上下界
 *
 * 思路：
 * 1. 先找出所有的逆序对，然后在过滤 nums[i] > 2 * nums[j]
 * 2. 分治
 */
public class LeetCode_493 {

    // Time: O(n ^ 2), Space: O(n), Faster: Time Limit Exceeded
    public int reversePairs(int[] nums) {

        if (nums == null || nums.length < 2) return 0;

        int cnt = 0;

        for (int i = 0; i < nums.length; ++i) {

            for (int j = i + 1; j < nums.length; ++j) {

                long num = nums[j];

                long num2 = nums[i];

                if (num2 > 2 * num) ++cnt;
            }
        }

        return cnt;
    }

    // Time: O(n * log(n)), Space: O(n), Faster: 93.92%
    public int reversePairMergeSort(int [] nums) {

        if (nums == null || nums.length == 0) return 0;

        int [] tmp = new int[nums.length];

        return sortAndCount(nums, 0, nums.length- 1, tmp);
    }

    private int sortAndCount(int[] arr, int low, int high, int[] tmp) {
        int cnt = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            cnt += sortAndCount(arr, low, mid, tmp);
            cnt += sortAndCount(arr, mid + 1, high, tmp);
            cnt += count(arr, low, mid, high);
            merge(arr, low, mid, high, tmp);
        }
        return cnt;
    }

    private void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, low, k);
    }

    private int count(int[] arr, int low, int mid, int high) {

        int i = low, j = mid + 1, cnt = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= 2L * arr[j]) {
                ++i;
            } else {
                cnt += (mid - i + 1);
                ++j;
            }
        }
        return cnt;
    }
}
