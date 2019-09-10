package bytedance.array;

import java.util.*;

/**
 * 数组 - 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 题意: 找到第k大的数, 数可以重复
 *
 * 思路:
 * 1. 记录数出现的次数, 然后比较
 * 2. 排个序, 直接找
 * 3. 堆维护
 */
public class FindKthLargest {

    // Time: o(n), Space: o(n)
    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        if (len < k) return 0;
        else return search(nums, 0, len - 1, k);
    }

    private int search(int[] nums, int left, int right, int k) {

        int m = partition(nums, left, right);

        if (m == k - 1) return nums[m];
        else if (m > k - 1) return search(nums, left, m - 1, k);
        else return search(nums, m + 1, right, k);
    }

    private int partition(int[] nums, int left, int right) {

        int tmp = nums[left];
        while (left < right) {
            tmp = nums[left];
            while (left < right) {

                while (left < right && nums[right] <= tmp) --right;
                swap(nums, left, right);
                while (left < right && nums[left] >= tmp) ++left;
                swap(nums, left, right);
            }
        }

        nums[left] = tmp;

        return left;
    }

    private void swap(int[] nums, int left, int right) {

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    // Time: o(nlogn), Space: o(1)
    public int findKthLargest2(int [] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    // Time: o(nlogn), Space: o(n)
    public int findKthLargest3(int [] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(); // 小顶堆

        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k) // 维护堆的大小为 K
                queue.poll();
        }
        return queue.peek();
    }
}
