package chapter2.topic1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. Kth Largest Element in an Array
 *
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 *
 * 题意：找到第k大的数，数组无序，且有重复
 *
 * 思路：
 * 1. 排序后，查找
 * 2. 举一个水池，在里面填充最大的数，把最小的数踢出
 * 3. 快速选择法
 *    i == k - 1 return
 *    i > k - 1  find left
 *    else       find right
 */
public class LeetCode_215 {

    // Time: o(n * log(k)), Space: o(k), Faster: 42.15%
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int num : nums) {

            if (queue.size() < k) queue.add(num);
            else if (num > queue.peek()) {

                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low], i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] < pivot) --j;
            if (i < j) swap(nums, i, j);
            while (i < j && nums[i] >= pivot) ++i;
            if (i < j) swap(nums, i, j);
        }
        return i;
    }

    // Time(avg): O(n), Time(worst): O(n^2), Space: O(1)
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p == k-1) return nums[p];
            else if (p > k-1) high = p - 1;
            else low = p + 1;
        }
        return -1;
    }
}
